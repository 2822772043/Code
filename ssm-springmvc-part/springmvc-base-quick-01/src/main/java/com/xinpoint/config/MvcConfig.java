package com.xinpoint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan("com.xinpoint.controller")
public class MvcConfig {

    public RequestMappingHandlerMapping handlerMapping(){

        return new  RequestMappingHandlerMapping();
    }

    public RequestMappingHandlerAdapter handlerAdapter(){

        return new RequestMappingHandlerAdapter();
    }
}
