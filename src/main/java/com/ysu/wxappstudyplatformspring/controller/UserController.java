package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public boolean addUser(@RequestBody User user){
        System.out.println("开始添加用户！");
        return userService.addUser(user);
    }

    @DeleteMapping("/user")
    public boolean deleteUser(@RequestParam String unionid){
        System.out.println("开始删除指定用户");
        return userService.deleteByIdUser(unionid);
    }

    @PutMapping("/user")
    public boolean updateUser(@RequestBody User user){
        System.out.println("开始更新指定用户信息");
        return userService.updateUser(user);
    }

    @PutMapping("/usertime")
    public boolean updatetimeUser(@RequestBody User user){
        user.setPunch_time(new Date(System.currentTimeMillis()));
        return userService.updateUser(user);
    }


    @GetMapping("/users")
    public List<User> selectAllUser(){
        System.out.println("开始查找全部用户！");
        return userService.selectAllUser();
    }

    @GetMapping("/user")
    public User selectByIdUser(@RequestParam String unionid){
        System.out.println("开始查找指定用户！");
        return userService.selectByIdUser(unionid);
    }


}
