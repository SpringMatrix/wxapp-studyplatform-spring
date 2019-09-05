package com.ysu.wxappstudyplatformspring.Dao;

import com.ysu.wxappstudyplatformspring.pojo.Follow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FollowDao {
    // 添加关注关系
    @Insert("insert into follow(unionid1,unionid2) values(#{unionid1},#{unionid2})")
    boolean addFollow(Follow follow);

    // 删除关注关系
    @Delete("delete from follow where unionid1=#{unionid1} and unionid2=#{unionid2}")
    boolean deleteFollow(Follow follow);

    // 查询所有关注关系
    @Select("select * from follow")
    List<Follow>selectAllFollow();

    // 查询指定关注关系
    @Select("select * from follow where unionid1=#{unionid1} and unionid2=#{unionid2}")
    Follow selectFollow(Follow follow);

    // 查询指定用户的关注关系
    @Select("select * from follow where unionid1=#{unionid1}")
    List<Follow> selectById1Follow(String unionid1);

    // 查询指定用户的被关注关系
    @Select("select * from follow where unionid2=#{unionid2}")
    List<Follow> selectById2Follow(String unionid2);

}
