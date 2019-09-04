package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.CourseService;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.Course;
import com.ysu.wxappstudyplatformspring.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value="添加课程", notes="根据Course对象创建课程")
    @ApiImplicitParam(name = "course", value = "课程详细实体course", required = true, dataType = "Course")
    @PostMapping("/addcourse")
    public boolean addCourse(@RequestBody Course course){
        System.out.println("开始添加课程！");
        return courseService.addCourse(course);
    }

    @DeleteMapping("/deletecourse")
    public boolean deleteByIdCourse(@RequestParam(value = "course_id",required = true) String course_id){
        System.out.println("开始删除课程");
        return courseService.deleteByIdCourse(course_id);
    }
}
