package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.AdminService;
import com.ysu.wxappstudyplatformspring.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public boolean addAdmin(@RequestBody Admin admin){
        System.out.println("开始添加管理员!");
        return adminService.addAdmin(admin);
    }

    @DeleteMapping("/admin")
    public boolean deleteAdmin(@RequestParam String admin_id){
        System.out.println("开始删除指定管理员!");
        return adminService.deleteByIdAdmin(admin_id);
    }

    @PutMapping("/admin")
    public boolean updateAdmin(@RequestBody Admin admin){
        System.out.println("开始更新指定管理员信息！");
        return adminService.updateAdmin(admin);
    }

    @GetMapping("/admins")
    public List<Admin> selectAllAdmin(){
        System.out.println("开始查找所有管理员！");
        return adminService.selectAllAdmin();
    }

    @GetMapping("/admin")
    public Admin selectAllAdmin(@RequestParam String admin_id){
        System.out.println("开始查找指定管理员！");
        return adminService.selectByIdAdmin(admin_id);
    }


}
