package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.BookmarkService;
import com.ysu.wxappstudyplatformspring.pojo.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class BookmarkController {
    @Autowired
    private BookmarkService bookmarkservice;

    @PostMapping("/bookmark")
    public boolean addBookmark(@RequestBody Bookmark bookmark){
        System.out.println("开始添加收藏信息!");
        return bookmarkservice.addBookmark(bookmark);
    }

    @DeleteMapping("/bookmark")
    public boolean deleteBookmark(@RequestBody Bookmark bookmark){
        System.out.println("开始删除收藏信息!");
        return bookmarkservice.deleteBookmark(bookmark);
    }

    @GetMapping("/bookmarks")
    public List<Bookmark> selectAllBookmark(){
        System.out.println("开始查询所有收藏信息!");
        return bookmarkservice.selectAllBookmark();
    }

    @GetMapping("/bookmark")
    public Bookmark selectBookamrk(@RequestBody Bookmark bookmark){
        System.out.println("开始查询指定收藏信息!");
        return bookmarkservice.selectBookmark(bookmark);
    }

    @GetMapping("/mybookmark")
    public List<Bookmark> selectByUserIdBookmark(@RequestParam String unionid){
        System.out.println("开始查询指定用户收藏信息!");
        return bookmarkservice.selectByUserIdBookmark(unionid);
    }

    @GetMapping("/bookmarker")
    public List<Bookmark> selectByCourseIdBookamrk(@RequestParam String course_id){
        System.out.println("开始查询指定课程收藏信息");
        return bookmarkservice.selectByCourseIdBookmark(course_id);
    }

}
