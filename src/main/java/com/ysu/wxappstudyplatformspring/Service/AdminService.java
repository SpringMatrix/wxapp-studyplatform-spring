package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.Admin;

import java.util.List;

public interface AdminService {
    //    添加管理员
    boolean addAdmin(Admin admin);

    //    删除指定管理员
    boolean deleteByIdAdmin(String admin_id);

    //    更改管理员信息
    boolean updateAdmin(Admin admin);

    //    查找全部管理员
    List<Admin> selectAllAdmin();

    //    按照ID查询指定用户
    Admin selectByIdAdmin(String admin_id);

    //    按照账号查询指定用户
    Admin selectByAccountAdmin(String admin_id);
}
