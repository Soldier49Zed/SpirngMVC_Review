package com.houx.mvc1126.controller;

import com.houx.mvc1126.pojo.Transaction;
import com.houx.mvc1126.validator.TransactionValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: HouX
 * @Date: 2020/11/28
 * @Description:
 */

@Controller
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping("/annotation")
    public ModelAndView annotationValidate(@Valid Transaction trans, Errors errors){
        if (errors.hasErrors()){
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList){
                //打印字段消息
                System.out.println("filed :" + error.getField() + "\t" + "msg: " + error.getDefaultMessage());
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("validate");
        return mv;
    }

    @InitBinder
    public void initBinder(DataBinder binder){
        //数据绑定器加入验证器
        binder.setValidator(new TransactionValidator());
    }

    @RequestMapping("/validator")
    public ModelAndView validator(@Valid Transaction trans,Errors errors){
        //是否存在错误
        if (errors.hasErrors()){
            //获取错误信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList){
                System.out.println("fied: " +error.getField() + "\t" + "msg: " + error.getDefaultMessage());
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
