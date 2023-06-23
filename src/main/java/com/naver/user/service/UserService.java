package com.naver.user.service;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public UserService() {
        System.out.println("----------------- UserService--------------");
    }

    int count = 0;
    public int test(){
        count++;
        return count;
    }
    @Bean
    public int getCount(){
        System.out.println("----------------- get Count --------------");
        return count;
    }

}
