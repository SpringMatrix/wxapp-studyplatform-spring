package com.ysu.wxappstudyplatformspring.Dao;

import com.ysu.wxappstudyplatformspring.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDao {

//    添加课程
    @Insert("insert into course(course_id,unionid,name,introduction,url,tag1,tag2,tag3,play_num,bookmark_num,visible) values(#{course_id},#{unionid},#{name},#{introduction},#{url},#{tag1},#{tag2},#{tag3},#{play_num},#{bookmark_num},#{visible})")
    boolean addCourse(Course course);
//    通过id删除课程
    @Delete("delete from course where course_id=#{course_id}")
    boolean deleteByIdCourse(int course_id);
//    更新课程信息
    @Update("update course set name=#{name},introduction=#{introduction},url=#{url},tag1=#{tag1},tag2=#{tag2},tag3=#{tag3},play_num=#{play_num},bookmark_num=#{bookmark_num},visible=#{visible} where course_id=#{course_id}")
    boolean updateCourse(Course course);
    //    审核通过
    @Update("update course set visible='1' where course_id=#{course_id}")
    boolean checkNews_Ok(int id);

    //    审核不通过
    @Update("update course set visible='0' where course_id=#{course_id}")
    boolean checkNews_No(int id);


//    查找全部课程
    @Select("select * from course")
    List<Course> selectAllCourse();
//    按照课程id查询
    @Select("select * from course where course_id=#{course_id}")
    Course selectByIdCourse_id(int course_id);
    //    按照上传人id查询
    @Select("select * from course where unionid=#{unionid}")
    List<Course> selectByIdUnionid(String unionid);

    //    按照用户收藏查询
    @Select("select * from course where course_id in (select * from (select course_id from bookmark WHERE unionid=#{unionid}) as bookmarkcourse)")
    List<Course> selectByUnionidBookmark(String unionid);
//    按照课程名字查询
    @Select("select * from course where name=#{name}")
    List<Course> selectByNameCourse(String name);
//    按照标签1查询
    @Select("select * from course where tag1=#{tag1}")
    List<Course> selectByTag1Course(String tag1);
    //    按照标签2查询
    @Select("select * from course where tag2=#{tag2}")
    List<Course> selectByTag2Course(String tag2);
    //    按照标签3查询
    @Select("select * from course where tag3=#{tag3}")
    List<Course> selectByTag3Course(String tag3);



}
