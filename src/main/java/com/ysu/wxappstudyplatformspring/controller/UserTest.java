package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserTest {

    @Autowired
    private UserService userService;


    @PostMapping("/adduser")
    public boolean addUser(@RequestBody User user){
        System.out.println("开始添加用户！");
        return userService.addUser(user);
    }

}
