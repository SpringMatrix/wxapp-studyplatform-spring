package com.ysu.wxappstudyplatformspring.Dao;

import com.ysu.wxappstudyplatformspring.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseDao {

//    查找全部课程
    @Select("select * from course")
    List<Course> selectAllCourse();

    @Select("select * from course where course_id=#{course_id}")
    Course selectByIdCourse_id(Course course);

    @Select("select * from course where name=#{name}")
    List<Course> selectByNameCourse(Course course);

    //@Select("select *")



}
