package com.ysu.wxappstudyplatformspring.Dao;


import com.ysu.wxappstudyplatformspring.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    //    添加用户
    @Insert("insert into user(unionid,name,sex,privacy,tag,follow_num,punch_time,avatar) values(#{unionid},#{name},#{sex},#{privacy},#{tag},#{follow_num},#{punch_time},#{avatar})")
    boolean addUser(User user);

    //    删除指定用户
    @Delete("delete from user where unionid=#{unionid}")
    boolean deleteByIdUser(String unionid);

    //    更改用户信息
    @Update("update user set name=#{name},sex=#{sex},privacy=#{privacy},tag=#{tag},follow_num=#{follow_num},punch_time=#{punch_time},point=#{point},avatar=#{avatar} where unionid=#{unionid}")
    boolean updateUser(User user);

    //    查找全部用户
    @Select("select * from user")
    List<User> selectAllUser();

    //    按照ID查询指定用户
    @Select("select * from user where unionid =#{unionid}")
    User selectByIdUser(String unionid);

    //    按照Name查询指定用户
    @Select("select * from user where name =#{name}")
    List<User> selectByNameUser(String name);

    //    按照Name模糊查询指定用户
    @Select("select * from user where name like CONCAT('%',#{name},'%')")
    List<User> selectByNameLikeUser(String name);

    //    按照指定ID用户的关注查询用户
    @Select("select * from user where unionid in (select * from (select unionid2 from follow WHERE unionid1=#{unionid}) as followuser)")
    List<User> selectByIdUserFollow(String unionid);

}