package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.User;

import java.util.List;

public interface UserService {

    //    添加用户
    boolean addUser(User user);

    //    查找全部用户
    List<User> selectAllUser();

    //    按照ID查询指定用户
    User selectByIdUser(User user);

    //    删除指定用户
    boolean deleteByIdUser(User user);

    //    更改用户信息
    boolean updateUser(User user);


}
