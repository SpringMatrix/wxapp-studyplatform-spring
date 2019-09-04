package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.AdminDao;
import com.ysu.wxappstudyplatformspring.Service.AdminService;
import com.ysu.wxappstudyplatformspring.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao admindao;

    // 添加管理员
    @Override
    public boolean addAdmin(Admin admin) {
        boolean flag = false;
        try {
            admindao.addAdmin(admin);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加管理员失败！");
            e.printStackTrace();
        }
        return flag;
    }

    // 删除管理员
    @Override
    public boolean deleteByIdAdmin(String admin_id) {
        boolean flag = false;
        try {
            admindao.deleteByIdAdmin(admin_id);
            System.out.println("删除管理员成功！");
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    // 更新管理员信息
    @Override
    public boolean updateAdmin(Admin admin) {
        boolean flag = false;
        try {
            admindao.updateAdmin(admin);
            System.out.println("更新管理员成功！");
            flag=true;
        } catch (Exception e) {
            System.out.println("更新失败！");
            e.printStackTrace();
        }
        return flag;
    }

    // 查找全部管理员
    @Override
    public List<Admin> selectAllAdmin() {
        return admindao.selectAllAdmin();
    }

    // 按照ID查找管理员
    @Override
    public Admin selectByIdAdmin(String admin_id){
        return admindao.selectByIdAdmin(admin_id);
    }

    // 按照账号查找管理员
    @Override
    public Admin selectByAccountAdmin(String account){
        return admindao.selectByAccountAdmin(account);
    }

}
