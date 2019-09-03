package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.UserDao;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userdao.addUser(user);
            flag=true;
        }catch (Exception e){
            System.out.println("添加用户失败！");
            e.printStackTrace();
        }
        return flag;
    }
}
