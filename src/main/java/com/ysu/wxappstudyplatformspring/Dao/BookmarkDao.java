package com.ysu.wxappstudyplatformspring.Dao;

import com.ysu.wxappstudyplatformspring.pojo.Bookmark;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookmarkDao {
    // 添加收藏关系
    @Insert("insert into bookmark(unionid,course_id) values(#{unionid},#{course_id})")
    boolean addBookmark(Bookmark bookmark);

    // 删除收藏关系
    @Delete("delete from bookmark where unionid=#{unionid} and course_id=#{course_id}")
    boolean deleteBookmark(Bookmark bookmark);

    // 查询所有收藏关系
    @Select("select * from bookmark")
    List<Bookmark> selectAllBookmark();

    // 查询指定收藏关系
    @Select("select * from bookmark where unionid=#{unionid} and course_id=#{course_id}")
    Bookmark selectBookmark(Bookmark bookmark);

    // 查询指定用户的所有收藏关系
    @Select("select * from bookmark where unionid=#{unionid}")
    List<Bookmark> selectByUserIdBookmark(String unionid);

    // 查询指定课程的所有收藏关系
    @Select("select * from bookmark where course_id=#{course_id}")
    List<Bookmark> selectByCourseIdBookmark(String course_id);

}
