package com.xinpoint.param;

import com.xinpoint.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/data")
    @ResponseBody
    public String data(String name ,int age){
        System.out.println("name = " + name + ", age = " + age);
        return"name = " + name + ", age = " + age ;
    }



    /*
    *
    * @RequestParam >形参列表    指定请求参数名 或者是否必须传递 或者非必须传递设置默认值
    *   用法：      @RequestParam(required = false,defaultValue = "1"
    *                   required 默认值为true 表示前端必须传递此参数，默认值是必须 不传会报400异常
    *                   defaultValue 表示默认值为1
    *
    * */
    @RequestMapping("/data1")
    @ResponseBody
    public String data1(@RequestParam String account,
                        @RequestParam(required = false,defaultValue = "1") int page){
        System.out.println("account = " + account + ", page = " + page);
        return "account = " + account + ", page = " + page;
    }


    @RequestMapping("/data3")
    @ResponseBody
    public String data3(User user){
        System.out.println("user = " + user);

        return user.toString();
    }

}
