package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.Follow;

import java.util.List;

public interface FollowService {
    // 添加关注关系
    boolean addFollow(Follow follow);

    //删除关注关系
    boolean deleteFollow(Follow follow);

    // 查询所有关注关系
    List<Follow> selectAllFollow();

    // 查询指定关注关系
    Follow selectFollow(Follow follow);

    // 查询指定用户关注关系
    List<Follow> selectById1Follow(String unionid1);

    // 查询指定用户被关注关系
    List<Follow> selectById2Follow(String unionid2);
}
