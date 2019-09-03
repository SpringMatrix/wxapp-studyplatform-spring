package com.ysu.wxappstudyplatformspring.Dao;


import com.ysu.wxappstudyplatformspring.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    @Insert("insert into user(unionid,name,sex,privacy,tag,follow_num,punch_time) values(#{unionid},#{name},#{sex},#{privacy},#{tag},#{follow_num},#{punch_time})")
    void addUser(User user);
}
