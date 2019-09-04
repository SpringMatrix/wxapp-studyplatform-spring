package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserTest {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        System.out.println("开始添加用户！");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam String unionid){
        System.out.println("开始删除指定用户");
        return userService.deleteByIdUser(unionid);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user){
        System.out.println("开始更新指定用户信息");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> selectAllUser(){
        System.out.println("开始查找全部用户！");
        return userService.selectAllUser();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User selectByIdUser(@RequestParam String unionid){
        System.out.println("开始查找指定用户！");
        return userService.selectByIdUser(unionid);
    }
}
