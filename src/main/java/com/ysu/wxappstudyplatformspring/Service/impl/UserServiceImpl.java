package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.UserDao;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //    添加用户
    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userDao.addUser(user);
            flag=true;
        }catch (Exception e){
            System.out.println("添加用户失败！");

            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定ID用户
    @Override
    public boolean deleteByIdUser(String unionid) {
        boolean flag=false;
        try {
            userDao.deleteByIdUser(unionid);
            System.out.println("删除用户成功！");
            flag=true;
        }catch (Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    //    更新用户信息
    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            userDao.updateUser(user);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //    查找全部用户
    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }


    //    按照ID查找用户
    @Override
    public User selectByIdUser(String unionid) {
        return userDao.selectByIdUser(unionid);
    }
}
