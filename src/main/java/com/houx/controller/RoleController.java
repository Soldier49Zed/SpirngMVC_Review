package com.houx.controller;

import com.houx.pojo.Role;
import com.houx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: HouX
 * @Date: 2020/11/24
 * @Description:
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService = null;

    @RequestMapping(value = "/getRole" ,method = RequestMethod.GET)
    public ModelAndView getRole(@RequestParam("id") Long id){
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        //给数据模型添加一个角色对象
        mv.addObject("role",role);
        return mv;
    }

}
