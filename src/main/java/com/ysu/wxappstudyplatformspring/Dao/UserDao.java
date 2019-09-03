package com.ysu.wxappstudyplatformspring.Dao;


import com.ysu.wxappstudyplatformspring.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

//    添加用户
    @Insert("insert into user(unionid,name,sex,privacy,tag,follow_num,punch_time) values(#{unionid},#{name},#{sex},#{privacy},#{tag},#{follow_num},#{punch_time})")
    void addUser(User user);

//    查找全部用户
    @Select("select * from user")
    void selectAllUser();

//    按照ID查询指定用户
}
