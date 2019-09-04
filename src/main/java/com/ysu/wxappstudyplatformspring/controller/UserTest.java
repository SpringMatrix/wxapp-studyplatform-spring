package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserTest {

    @Autowired
    private UserService userService;


    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user){
        System.out.println("开始添加用户！");
        return userService.addUser(user);
    }

    @PostMapping("/selectAllUser")
    public List<User> selectAllUser(){
        System.out.println("开始查找全部用户！");
        return userService.selectAllUser();
    }

    @PostMapping("/selectByIdUser")
    public User selectByIdUser(@RequestBody User user){
        System.out.println("开始查找指定用户！");
        return userService.selectByIdUser(user);
    }

    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody User user){
        System.out.println("开始更新指定用户信息");
        return userService.updateUser(user);
    }

    @PostMapping("/deleteUser")
    public boolean deleteUser(@RequestBody User user){
        System.out.println("开始删除指定用户");
        return userService.deleteByIdUser(user);
    }
}
