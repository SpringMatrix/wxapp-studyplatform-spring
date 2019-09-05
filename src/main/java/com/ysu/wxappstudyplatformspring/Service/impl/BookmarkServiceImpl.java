package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.BookmarkDao;
import com.ysu.wxappstudyplatformspring.Service.BookmarkService;
import com.ysu.wxappstudyplatformspring.pojo.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    @Autowired
    private BookmarkDao bookmarkdao;

    @Override
    public boolean addBookmark(Bookmark bookmark){
        boolean flag = false;
        try{
            bookmarkdao.addBookmark(bookmark);
            flag = true;
        }catch(Exception e){
            System.out.print("添加收藏关系失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteBookmark(Bookmark bookmark){
        boolean flag = false;
        try{
            bookmarkdao.deleteBookmark(bookmark);
            flag = true;
        }catch(Exception e){
            System.out.println("删除关注关系失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Bookmark> selectAllBookmark(){
        return bookmarkdao.selectAllBookmark();
    }

    @Override
    public Bookmark selectBookmark(Bookmark bookmark){
        return bookmarkdao.selectBookmark(bookmark);
    }

    @Override
    public List<Bookmark> selectByUserIdBookmark(String unionid){
        return bookmarkdao.selectByUserIdBookmark(unionid);
    }

    @Override
    public List<Bookmark> selectByCourseIdBookmark(String course_id){
        return bookmarkdao.selectByCourseIdBookmark(course_id);
    }
}
