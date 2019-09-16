package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.BookmarkService;
import com.ysu.wxappstudyplatformspring.pojo.Bookmark;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bookmarks")
public class BookmarkController {
    @Autowired
    private BookmarkService bookmarkservice;

    @ApiOperation(value="添加收藏关系", notes="输入Bookmark对象，创建收藏关系，返回true")
    @ApiImplicitParam(name = "bookmark", value = "收藏关系类详细实体bookmark", required = true, dataType = "Bookmark")
    @PostMapping("/")
    public boolean addBookmark(@RequestBody Bookmark bookmark){
        System.out.println("开始添加收藏信息!");
        return bookmarkservice.addBookmark(bookmark);
    }

    @ApiOperation(value="删除收藏关系", notes="输入Bookmark对象，删除收藏关系，返回true")
    @ApiImplicitParam(name = "bookmark", value = "收藏关系类详细实体bookmark", required = true, dataType = "Bookmark")
    @DeleteMapping("/")
    public boolean deleteBookmark(@RequestBody Bookmark bookmark){
        System.out.println("开始删除收藏信息!");
        return bookmarkservice.deleteBookmark(bookmark);
    }

    @ApiOperation(value="查找全部收藏关系", notes="返回所有Bookmark对象")
    @GetMapping("/all")
    public List<Bookmark> selectAllBookmark(){
        System.out.println("开始查询所有收藏信息!");
        return bookmarkservice.selectAllBookmark();
    }

    @ApiOperation(value="按照用户ID和课程ID查询收藏关系", notes="输入去除Id的Bookmark子对象，查询收藏关系，返回单个Bookmark对象")
    @GetMapping("/")
    public Bookmark selectBookamrk(@RequestParam String unionid, @RequestParam String course_id){
        Bookmark bookmark = new Bookmark();
        bookmark.setUnionid(unionid);
        bookmark.setCourse_id(course_id);
        System.out.println("开始查询指定收藏信息!");
        return bookmarkservice.selectBookmark(bookmark);
    }

    @ApiOperation(value="按照用户ID查找收藏关系", notes="输入用户ID unionid，查询收藏关系，返回多个Bookmark对象")
    @ApiImplicitParam(name = "unionid", value = "用户ID", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid")
    public List<Bookmark> selectByUserIdBookmark(@RequestParam String unionid){
        System.out.println("开始查询指定用户收藏信息!");
        return bookmarkservice.selectByUserIdBookmark(unionid);
    }

    @ApiOperation(value="按照课程ID查找收藏关系", notes="输入课程ID course_id，查询收藏关系，返回多个Bookmark对象")
    @ApiImplicitParam(name = "course_id", value = "课程ID", required = true, paramType = "query", dataType = "String")
    @GetMapping("/course-id")
    public List<Bookmark> selectByCourseIdBookamrk(@RequestParam String course_id){
        System.out.println("开始查询指定课程收藏信息");
        return bookmarkservice.selectByCourseIdBookmark(course_id);
    }

}
