package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.FollowService;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.Follow;
import com.ysu.wxappstudyplatformspring.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/follows")
public class FollowController {
    @Autowired
    private FollowService followService;
    @Autowired
    private UserService userService;

    @ApiOperation(value="添加关注关系", notes="输入Follow对象，创建关注关系，返回true")
    @ApiImplicitParam(name = "follow", value = "关注关系详细实体follow", required = true, dataType = "Follow")
    @PostMapping("/")
    public boolean addFollow(@RequestBody Follow follow) {
        System.out.println("开始添加关注关系!");
        if(follow.getUnionid1().equals(follow.getUnionid2())) {
            return false;
        }
        User user = userService.selectByIdUser(follow.getUnionid2());
        user.setFollow_num(user.getFollow_num() + 1);
        userService.updateUser(user);
        return followService.addFollow(follow);
    }

    @ApiOperation(value="删除关注关系", notes="输入Follow对象，删除关注关系，返回true")
    @ApiImplicitParam(name = "follow", value = "关注关系详细实体follow", required = true, dataType = "Follow")
    @CrossOrigin(origins = "*")
    @DeleteMapping("/")
    public boolean deleteFollow(@RequestBody Follow follow) {
        System.out.println("开始删除关注关系!");
        User user = userService.selectByIdUser(follow.getUnionid2());
        user.setFollow_num(user.getFollow_num() - 1);
        userService.updateUser(user);
        return followService.deleteFollow(follow);
    }

    @ApiOperation(value="查找全部关注关系", notes="返回所有Follow对象")
    @GetMapping("/all")
    public List<Follow> selectAllFollow() {
        System.out.println("开始查询所有关注关系!");
        return followService.selectAllFollow();
    }

    @ApiOperation(value="按照关注者用户ID和被关注者用户ID查询关注关系", notes="输入无Id的Follow子对象，查询关注关系，返回单个Follow对象")
    @ApiImplicitParam(name = "follow", value = "关注关系详细实体follow", required = true, paramType = "query",dataType = "Follow")
    @GetMapping("/")
    public Follow selectFollow(@RequestParam String unionid1, @RequestParam String unionid2) {
        System.out.println("开始查询指定关注关系！");
        Follow follow = new Follow();
        follow.setUnionid1(unionid1);
        follow.setUnionid2(unionid2);
        return followService.selectFollow(follow);
    }

    @ApiOperation(value="按照用户ID查找关注关系", notes="输入用户ID1 unionid1，查询关注关系，返回多个Follow对象")
    @ApiImplicitParam(name = "unionid1", value = "用户ID1", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid1")
    public List<Follow> selectById1Follow(@RequestParam String unionid1) {
        System.out.println("开始查询指定用户关注关系!");
        return followService.selectById1Follow(unionid1);
    }

    @ApiOperation(value="按照用户ID查找被关注关系", notes="输入用户ID2 unionid2，查询关注关系，返回多个Follow对象")
    @ApiImplicitParam(name = "unionid2", value = "用户ID1", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid2")
    public List<Follow> selectById2Follow(@RequestParam String unionid2) {
        System.out.println("开始查询指定用户被关注关系!");
        return  followService.selectById2Follow(unionid2);
    }
}
