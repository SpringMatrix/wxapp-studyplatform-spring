package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.CourseDao;
import com.ysu.wxappstudyplatformspring.Service.CourseService;
import com.ysu.wxappstudyplatformspring.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    //    添加课程
    @Override
    public boolean addCourse(Course course) {
        boolean flag=false;
        try{
            courseDao.addCourse(course);
            flag=true;
        }catch (Exception e){
            System.out.println("添加课程失败！");
            e.printStackTrace();
        }
        return flag;
    }
    //    通过id删除课程
    @Override
    public boolean deleteByIdCourse(String course_id) {
        boolean flag=false;
        try{
            courseDao.deleteByIdCourse(course_id);
            flag=true;
        }catch (Exception e){
            System.out.println("删除课程失败");
            e.printStackTrace();
        }
        return flag;
    }
    //    更新课程信息
    @Override
    public boolean updateCourse(Course course) {
        boolean flag=false;
        try {
            courseDao.updateCourse(course);
            flag=true;
        }catch (Exception e){
            System.out.println("更新课程信息失败");
            e.printStackTrace();
        }
        return flag;
    }
    //    查找全部课程
    @Override
    public List<Course> selectAllCourse() {
        return courseDao.selectAllCourse();
    }
    //    按照课程id查询
    @Override
    public Course selectByIdCourse(String course_id) {
        return courseDao.selectByIdCourse_id(course_id);
    }
    //    按照课程名字查询
    @Override
    public List<Course> selectByNameCourse(String name) {
        return courseDao.selectByNameCourse(name);
    }
    //    按照标签1查询
    @Override
    public List<Course> selectByTag1Course(String tag1) {
        return courseDao.selectByTag1Course(tag1);
    }
    //    按照标签2查询
    @Override
    public List<Course> selectByTag2Course(String tag2) {
        return courseDao.selectByTag2Course(tag2);
    }
    //    按照标签3查询
    @Override
    public List<Course> selectByTag3Course(String tag3) {
        return courseDao.selectByTag3Course(tag3);
    }
}
