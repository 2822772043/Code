package com.xinpoint.json;


import com.xinpoint.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
@RequestMapping("/json")
@ResponseBody
public class JsonController {

    @PostMapping("/data")
    public String data(@RequestBody Person person){

        System.out.println("person = " + person);

        return person.toString();

    }

}
