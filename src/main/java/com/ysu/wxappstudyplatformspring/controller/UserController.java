package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value="添加用户", notes="输入User对象，创建用户，返回true")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/")
    public boolean addUser(@RequestBody User user){
        System.out.println("开始添加用户！");
        return userService.addUser(user);
    }

    @ApiOperation(value="删除用户", notes="输入用户ID unionid，删除用户，返回true")
    @ApiImplicitParam(name = "unionid", value = "用户ID", required = true, paramType = "query", dataType = "String")
    @DeleteMapping("/")
    public boolean deleteUser(@RequestParam String unionid){
        System.out.println("开始删除指定用户");
        return userService.deleteByIdUser(unionid);
    }

    @ApiOperation(value="更新用户", notes="输入User对象，更新用户，返回true")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PutMapping("/")
    public boolean updateUser(@RequestBody User user){
        System.out.println("开始更新指定用户信息");
        return userService.updateUser(user);
    }

    @ApiOperation(value="查找全部用户", notes="返回所有User对象")
    @GetMapping("/all")
    public List<User> selectAllUser(){
        System.out.println("开始查找全部用户！");
        return userService.selectAllUser();
    }

    @ApiOperation(value="按照用户ID查找用户", notes="输入用户ID unionid，查找用户，返回单个User对象")
    @ApiImplicitParam(name = "unionid", value = "用户ID", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid")
    public User selectByIdUser(@RequestParam String unionid){
        System.out.println("开始查找指定用户！");
        return userService.selectByIdUser(unionid);
    }
}
