package com.houx.mvc1126.controller;

import com.houx.mvc1126.pojo.Role;
import com.houx.mvc1126.pojo.RoleParams;
import com.houx.mvc1126.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @Author: HouX
 * @Date: 2020/11/26
 * @Description:
 */
@Controller
@RequestMapping("/params")
public class ParamsController {

    //接收普通请求参数 无注解获取HTTP请求参数的代码
    @RequestMapping("/commonParams")
    public ModelAndView commonParams(String roleName, String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }

    //多个参数情况下,采用POJO来管理,通过POJO来获取HTTP请求参数
    @RequestMapping("/commonParamPojo")
    public ModelAndView commonParamPojo(RoleParams roleParams){
        System.out.println("roleName => " + roleParams.getRoleName());
        System.out.println("note => " + roleParams.getNote());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }

    //使用@RequestParam注解获取参数 将index.jsp中的参数名roleName改为role_name
    @RequestMapping("requestParam")
    //@RequestParams默认该参数不能为空,否则跑出异常，除非修改required = false
    public ModelAndView requestParam(@RequestParam(value = "role_name",required = false)String roleName,String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    //使用URL传递参数

    @Autowired
    RoleService roleService;

    @RequestMapping("/getRole/{id}")
    public ModelAndView pathVariable(@PathVariable("id") Long id){
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        //绑定数据模型
        mv.addObject(role);
        //设置为json视图
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }


    //传递JSON参数
    @RequestMapping("/findRoles")
    public ModelAndView findRoles(@RequestBody(required = false) RoleParams roleParams){
        List<Role> roleList = roleService.findRoles(roleParams);
        ModelAndView mv = new ModelAndView();
        mv.addObject(roleList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //接收列表数据和表单序列化
    @RequestMapping("/deleteRoles")
    public ModelAndView deleteRoles(@RequestBody(required = false) List<Long> idList){
        ModelAndView mv = new ModelAndView();

        int total = roleService.deleteRoles(idList);

        mv.addObject("total",total);

        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //获取角色列表参数
    @RequestMapping("/addRoles")
    public ModelAndView addRoles(@RequestBody(required = false) List<Role> roleList){
        ModelAndView mv = new ModelAndView();
        int total = roleService.insertRole((Role) roleList);
        mv.addObject("total",total);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //接收序列化表单
    @RequestMapping("/commonParamPojo2")
    public ModelAndView commonParamPojo2(String roleName,String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


}
