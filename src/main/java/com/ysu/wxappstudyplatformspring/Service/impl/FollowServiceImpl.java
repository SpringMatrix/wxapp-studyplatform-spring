package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.FollowDao;
import com.ysu.wxappstudyplatformspring.Service.FollowService;
import com.ysu.wxappstudyplatformspring.pojo.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService{
    @Autowired
    private FollowDao followDao;

    // 添加管理员
    @Override
    public boolean addFollow(Follow follow){
        boolean flag = false;
        try{
            followDao.addFollow(follow);
            flag = true;
        }catch(Exception e){
            System.out.print("添加关注关系失败");
            e.printStackTrace();
        }
        return flag;
    }

    // 删除关注关系
    @Override
    public boolean deleteFollow(Follow follow){
        boolean flag = false;
        try{
            followDao.deleteFollow(follow);
            flag = true;
        }catch(Exception e){
            System.out.println("删除关注关系失败");
            e.printStackTrace();
        }
        return flag;
    }

    // 查询所有关注关系
    public List<Follow> selectAllFollow(){
        return followDao.selectAllFollow();
    }

    // 查询指定关注关系
    public Follow selectFollow(Follow follow){
        return followDao.selectFollow(follow);
    }

    // 查询指定用户关注关系
    public List<Follow> selectById1Follow(String unionid1){
        return followDao.selectById1Follow(unionid1);
    }

    // 查询指定用户被关注关系
    public List<Follow> selectById2Follow(String unionid2){
        return followDao.selectById2Follow(unionid2);
    }

    //TODO 查询用户关注总数

    //TODO 查询用户被关注总数
}
