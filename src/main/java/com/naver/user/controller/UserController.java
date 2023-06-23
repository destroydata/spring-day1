package com.naver.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 어노테이션(psa)
@Controller
public class UserController {
    @RequestMapping(method = RequestMethod.GET, value = "/user/test")
    public String test(){
        return "test";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/test2")
    public String test2(){
        return "index";
    }
}
