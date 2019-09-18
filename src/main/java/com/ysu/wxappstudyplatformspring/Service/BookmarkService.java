package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.Bookmark;

import java.util.List;

public interface BookmarkService {
    // 添加收藏关系
    boolean addBookmark(Bookmark bookmark);

    // 删除关注关系
    boolean deleteBookmark(Bookmark bookmark);

    // 删除收藏关系
    boolean deleteByIdBookmark(String id);

    // 查询所有收藏关系
    List<Bookmark> selectAllBookmark();

    // 查询指定收藏关系
    Bookmark selectBookmark(Bookmark bookmark);

    // 查询指定用户收藏关系
    List<Bookmark> selectByUserIdBookmark(String unionid);

    // 查询指定课程收藏关系
    List<Bookmark> selectByCourseIdBookmark(String course_id);

}
