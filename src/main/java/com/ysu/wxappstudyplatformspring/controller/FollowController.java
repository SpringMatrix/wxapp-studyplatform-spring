package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.FollowService;
import com.ysu.wxappstudyplatformspring.pojo.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FollowController {
    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public boolean addFollow(@RequestBody Follow follow) {
        System.out.println("开始添加关注关系!");
        return followService.addFollow(follow);
    }

    @DeleteMapping("/follow")
    public boolean deleteFollow(@RequestBody Follow follow) {
        System.out.println("开始删除关注关系!");
        return followService.deleteFollow(follow);
    }

    @GetMapping("/follows")
    public List<Follow> selectAllFollow() {
        System.out.println("开始查询所有关注关系!");
        return followService.selectAllFollow();
    }

    @GetMapping("/follow")
    public Follow selectFollow(@RequestBody Follow follow) {
        System.out.println("开始查询指定关注关系！");
        return followService.selectFollow(follow);
    }

    @GetMapping("/myfollow")
    public List<Follow> selectById1Follow(@RequestParam String unionid1) {
        System.out.println("开始查询指定用户关注关系!");
        return followService.selectById1Follow(unionid1);
    }

    @GetMapping("/myfollower")
    public List<Follow> selectById2Follow(@RequestParam String unionid2) {
        System.out.println("开始查询指定用户被关注关系!");
        return  followService.selectById2Follow(unionid2);
    }
}
