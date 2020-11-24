package com.houx.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: HouX
 * @Date: 2020/11/24
 * @Description:
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //Spring IoC容器配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //可以返回Spring 的Java配置文件数组
        return new Class<?>[] {};
    }

    //DispatcherServlet的URI映射关系
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //可以返回Spring 的Java配置文件数组
        return new Class<?>[] {WebConfig.class};
    }

    //DispatcherServlet拦截内容
    @Override
    protected String[] getServletMappings() {
        return new String[] {"*.do"};
    }
}
