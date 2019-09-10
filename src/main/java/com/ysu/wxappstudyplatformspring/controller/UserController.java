package com.ysu.wxappstudyplatformspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.User;
import com.ysu.wxappstudyplatformspring.pojo.WxResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private String wxspAppid = "wxb95bf13fd4bc1c24";
    //小程序的 app secret (在微信小程序管理后台获取)
    private String wxspSecret = "78f017bfa5f8fe5eea30a3f007ea7153";
    private String openid;
    private String session_key;


    @ApiOperation(value = "添加用户", notes = "输入User对象，创建用户，返回true")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/")
    public boolean addUser(@RequestBody User user) {
        System.out.println("开始添加用户！");
        return userService.addUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "输入用户ID unionid，删除用户，返回true")
    @ApiImplicitParam(name = "unionid", value = "用户ID", required = true, paramType = "query", dataType = "String")
    @DeleteMapping("/")
    public boolean deleteUser(@RequestParam String unionid) {
        System.out.println("开始删除指定用户");
        return userService.deleteByIdUser(unionid);
    }

    @ApiOperation(value = "更新用户", notes = "输入User对象，更新用户，返回true")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PutMapping("/")
    public boolean updateUser(@RequestBody User user) {
        System.out.println("开始更新指定用户信息");
        return userService.updateUser(user);
    }

    @ApiOperation(value = "查找全部用户", notes = "返回所有User对象")
    @GetMapping("/all")
    public List<User> selectAllUser() {
        System.out.println("开始查找全部用户！");
        return userService.selectAllUser();
    }

    @ApiOperation(value = "按照用户ID查找用户", notes = "输入用户ID unionid，查找用户，返回单个User对象")
    @ApiImplicitParam(name = "unionid", value = "用户ID", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid")
    public User selectByIdUser(@RequestParam String unionid) {
        System.out.println("开始查找指定用户！");
        return userService.selectByIdUser(unionid);
    }

    @ApiOperation(value = "用户登录", notes = "输入微信code，调用微信接口auth.code2Session，返回openid")
    @ApiImplicitParam(name = "code", value = "微信code", required = true, paramType = "query", dataType = "String")
    @PostMapping("/login")
    public User userLogin(@RequestParam String code, @RequestParam String name) throws IOException {
        System.out.println("用户开始登录!");
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();// 发送request请求
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=authorization_code";//参数
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + params;// 微信接口 用于查询oponid
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("response:" + response);
        WxResponse wxResponse = objectMapper.readValue(response, WxResponse.class);
        session_key = wxResponse.getSession_key();
        openid = wxResponse.getOpenid();
        System.out.println("session_key:" + session_key);
        System.out.println("openid:" + openid);

        User user = userService.selectByIdUser(openid); //数据库寻找id
        //检测是否已在数据库
        if (user != null) {
            System.out.println("已注册！");
            return user;
        } else {
            user = new User();
            user.setUnionid(openid);
            user.setName(name);
            System.out.println("未注册！");
            if (userService.addUser(user)) {
                return user;
            }
        }
        return user;
    }

    //用户打卡
    @PostMapping("/punch")
    boolean userPunch(@RequestParam String unionid) {
        User user = userService.selectByIdUser(unionid);
        Date today = new Date(System.currentTimeMillis());  // 今日日期

        //上次打卡时间为空或和今天不是相同日期（不是今天打的卡）
        if (user.getPunch_time() == null || user.getPunch_time().toString().equals(today.toString()) == false) {
            user.setPunch_time(new Date(System.currentTimeMillis()));
            user.setPoint(user.getPoint() + 1);
            System.out.println("用户打卡成功!");
            return userService.updateUser(user);
        } else {
            System.out.println("用户打卡失败!");
            return false;
        }
    }

    //用户更名
    @PostMapping("/rename")
    boolean userRename(@RequestParam String unionid, @RequestParam String newName) {
        User user = userService.selectByIdUser(unionid);
        user.setName(newName);
        return userService.updateUser(user);
    }

    //用户修改性别
    @PostMapping("/regender")
    boolean userRegender(@RequestParam String unionid, @RequestParam String newSex) {
        User user = userService.selectByIdUser(unionid);
        user.setSex(newSex);
        return userService.updateUser(user);
    }

    //修改用户隐私政策
    @PostMapping("/reprivacy")
    boolean userReprivacy(@RequestParam String unionid) {
        User user = userService.selectByIdUser(unionid);
        user.setPrivacy(!user.getPrivacy());
        return userService.updateUser(user);
    }
}
