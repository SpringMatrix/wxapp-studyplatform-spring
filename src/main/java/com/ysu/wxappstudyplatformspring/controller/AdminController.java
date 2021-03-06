package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.AdminService;
import com.ysu.wxappstudyplatformspring.pojo.Admin;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value="添加管理员", notes="输入Admin对象，创建管理员，返回true")
    @ApiImplicitParam(name = "admin", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PostMapping("/")
    public boolean addAdmin(@RequestBody Admin admin){
        System.out.println("开始添加管理员!");
        return adminService.addAdmin(admin);
    }

    @ApiOperation(value="删除管理员", notes="输入管理员ID Admin Id，删除管理员，返回true")
    @ApiImplicitParam(name = "admin_id", value = "管理员Id", required = true, paramType = "query", dataType = "String")
    @DeleteMapping("/")
    public boolean deleteAdmin(@RequestParam String admin_id){
        System.out.println("开始删除指定管理员!");
        return adminService.deleteByIdAdmin(admin_id);
    }

    @ApiOperation(value="更新管理员", notes="输入Admin对象，更新管理员，返回true")
    @ApiImplicitParam(name = "admin", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PutMapping("/")
    public boolean updateAdmin(@RequestBody Admin admin){
        System.out.println("开始更新指定管理员信息！");
        return adminService.updateAdmin(admin);
    }

    @ApiOperation(value="查找全部管理员", notes="返回所有Admin对象")
    @GetMapping("/all")
    public List<Admin> selectAllAdmin(){
        System.out.println("开始查找所有管理员！");
        return adminService.selectAllAdmin();
    }

    @ApiOperation(value="按照管理员ID查找管理员", notes="输入管理员ID admin_id，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "admin_id", value = "管理员Id", required = true, paramType = "query", dataType = "String")
    @GetMapping("/id")
    public Admin selectByIdAdmin(@RequestParam String admin_id){
        System.out.println("开始查找指定管理员！");
        return adminService.selectByIdAdmin(admin_id);
    }

    @ApiOperation(value="验证登陆", notes="输入管理员账号，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "admin1", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody Admin admin1){
        System.out.println("开始匹配指定管理员账号密码是否正确！");
        Admin admin=adminService.selectByAccountAdmin(admin1.getAccount());
        if (admin.getPassword().equals(admin1.getPassword())){
            System.out.println("admin账号正确");
            return true;
        }
        return false;
    }

}
