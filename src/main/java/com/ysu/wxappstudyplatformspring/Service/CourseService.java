package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.Course;

import java.util.List;

public interface CourseService {

    //    添加课程
    boolean addCourse(Course course);


    //    通过id删除课程
    boolean deleteByIdCourse(int course_id);


    //    更新课程信息
    boolean updateCourse(Course course);


    //    审核通过
    boolean checkNews_Ok(int id);

    //    审核不通过
    boolean checkNews_No(int id);

    //    查找全部课程
    List<Course> selectAllCourse();


    //    按照课程id查询
    Course selectByIdCourse(int course_id);

    //    按照上传人id查询
    Course selectByIdUnionid(String unionid);

    //    按照用户收藏查询
    List<Course> selectByUnionidBookmark(String unionid);


    //    按照课程名字查询
    List<Course> selectByNameCourse(String name);


    //    按照标签1查询
    List<Course> selectByTag1Course(String tag1);


    //    按照标签2查询
    List<Course> selectByTag2Course(String tag2);


    //    按照标签3查询
    List<Course> selectByTag3Course(String tag3);
}
