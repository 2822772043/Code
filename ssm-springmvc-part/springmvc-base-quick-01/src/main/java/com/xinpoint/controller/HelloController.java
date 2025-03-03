package com.xinpoint.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class HelloController {

    @RequestMapping("springmvc/hello")
    @ResponseBody
    public String hello(){

        System.out.println("HelloController.hello" );
        
        return "hello springmvc!!!";
    }

}
