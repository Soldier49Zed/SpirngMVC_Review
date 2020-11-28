package com.houx.mvc1126.controller;

import com.houx.mvc1126.pojo.Role;
import com.houx.mvc1126.service.RoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @Author: HouX
 * @Date: 2020/11/28
 * @Description:
 */

@Controller
@RequestMapping("/attribute")
//可以配置数据模型的名称和类型，两者取或关系
@SessionAttributes(names = {"id"}, types = {Role.class})
public class AttributeController {

    @Autowired
    private RoleService roleService = null;

    @RequestMapping("/requestAttribute")
    public ModelAndView reqAttr(@RequestAttribute("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());

        return mv;
    }

    @RequestMapping("/sessionAttributes")
    public ModelAndView sessionAttrs(Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        //根据类型，Session将会保存角色信息
        mv.addObject("role", role);
        //根据名称，Session将会保存id
        mv.addObject("id", id);
        //视图名称,定义跳转到一个JSP文件上
        mv.setViewName("sessionAttribute");
        return mv;

    }

    @RequestMapping("/sessionAttribute")
    public ModelAndView sessionAttr(@SessionAttribute("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject(role);
        mv.setView(new MappingJackson2JsonView());
        return  mv;
    }



}
