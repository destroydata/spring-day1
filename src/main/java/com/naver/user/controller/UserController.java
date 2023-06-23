package com.naver.user.controller;

import com.naver.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 어노테이션(psa)
// 어떤 기술을 내부에 숨기고 개발자들한테 편의성을 제공하는 추상화 기법
@Controller
@RequestMapping(value = "/user")
public class UserController {
    List<Map<String, String>> users = new ArrayList<>();
//    @Autowired
    private final UserService userService;
    private final ApplicationContext applicationContext;

    public UserController(UserService userService, ApplicationContext applicationContext) {
        System.out.println("----------------- UserController --------------");
        this.userService = userService;
        this.applicationContext = applicationContext;
    }

    //    @RequestMapping(method = RequestMethod.GET, value = "/test")
    @GetMapping("/test")
    public String test(){
        return "test";
    }
//    @RequestMapping(method = RequestMethod.GET, value = "/test2")
    @GetMapping("/test2")
    public String test2(Model model){
//        System.out.println(new UserService().test());
//        new UserService().test()
        System.out.println(userService.test());
        String[] beanDefinitionNames = applicationContext
                .getBeanDefinitionNames();
        for (String s:beanDefinitionNames) {
            System.out.println(s);
        }
        model
                .addAttribute("serverTime"
                        , LocalDateTime.now().toString());
        System.out.println(users);
        return "index";
    }
    @PostMapping("/test2")
    public String insertUser(HttpServletRequest req) {
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pw", pw);
        users.add(map);
        return "redirect:/user/test2";
    }
}
