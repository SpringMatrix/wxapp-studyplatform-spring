package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.CourseService;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.Course;
import com.ysu.wxappstudyplatformspring.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.List;

@RestController
@RequestMapping(value = "/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    //    添加课程
    @ApiOperation(value = "添加课程", notes = "根据Course对象创建课程")
    @ApiImplicitParam(name = "course", value = "课程详细实体course", required = true, dataType = "Course")
    @PostMapping("/")
    public boolean addCourse(@RequestBody Course course) {
        System.out.println("开始添加课程！");
        return courseService.addCourse(course);
    }


//    删除课程

    @ApiOperation(value = "删除课程", notes = "根据Id删除Course对象")
    @ApiImplicitParam(name = "course_id", value = "课程id号course_id", required = true, paramType = "query", dataType = "int")
    @DeleteMapping("/")
    public boolean deleteByIdCourse(@RequestParam(value = "course_id") int course_id) {
        System.out.println("开始删除课程");
        return courseService.deleteByIdCourse(course_id);
    }


    //    更新课程
    @ApiOperation(value = "更新课程信息", notes = "根据Couerse对象自动获取其中Id并更新对应课程信息")
    @ApiImplicitParam(name = "course", value = "课程course", required = true, dataType = "Course")
    @PutMapping("/")
    public boolean updateCourse(@RequestBody Course course) {
        System.out.println("开始更新课程信息");
        return courseService.updateCourse(course);
    }

    //    审核通过
    @ApiOperation(value = "课程审核通过", notes = "管理员审核通过指定id课程")
    @ApiImplicitParam(name = "id", value = "课程id", required = true, paramType = "query", dataType = "int")
    @PutMapping("/check-ok")
    public boolean checkNews_Ok(@RequestParam int id) {
        return courseService.checkNews_Ok(id);
    }


    //    审核不通过
    @ApiOperation(value = "课程审核不通过", notes = "管理员审核不通过指定id课程")
    @ApiImplicitParam(name = "id", value = "课程id", required = true, paramType = "query", dataType = "int")
    @PutMapping("/check-no")
    public boolean checkNews_No(@RequestParam int id) {
        return courseService.checkNews_No(id);
    }


    //    查找全部课程
    @ApiOperation(value = "查找全部课程信息", notes = "返回所有Course对象")
//    @ApiImplicitParam(name = "course", value = "课程course", required = false, dataType = "Course")
    @GetMapping("/all")
    public List<Course> selectAllCourse() {
        return courseService.selectAllCourse();
    }


    //    按照Id查找对应的课程
    @ApiOperation(value = "按照Id查找对应的课程", notes = "根据Couer_id查找对应的Course对象")
    @ApiImplicitParam(name = "course_id", value = "课程id号course_id", required = true, paramType = "query", dataType = "int")
    @GetMapping("/id")
    public Course selectByIdCourse(@RequestParam(value = "course_id") int course_id) {
        Course course = courseService.selectByIdCourse(course_id);
        course.setPlay_num(Integer.toString(Integer.parseInt(course.getPlay_num()) + 1));
        courseService.updateCourse(course);
        return courseService.selectByIdCourse(course_id);
    }

    //    按照上传人id查询
    @ApiOperation(value = "按照上传人Id查找对应上传的课程", notes = "根据unionid查找对应的Course对象")
    @ApiImplicitParam(name = "unionid", value = "上传人unionid号", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid")
    public List<Course> selectByIdUnionid(@RequestParam(value = "unionid") String unionid) {
        return courseService.selectByIdUnionid(unionid);
    }

    //    按照用户id查询用户收藏课程
    @ApiImplicitParam(name = "id", value = "课程id", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid/bookmark")
    public List<Course> selectByUnionidBookmark(@RequestParam(value = "unionid") String unionid) {
        return courseService.selectByUnionidBookmark(unionid);
    }


    //    按照Tag1查找对应的课程
    @ApiOperation(value = "按照Tag1查找对应的课程", notes = "根据Tag1查找对应的Course对象")
    @ApiImplicitParam(name = "tag1", value = "课程Tag1", required = true, paramType = "query", dataType = "String")
    @GetMapping("/tag1")
    public List<Course> selectByTag1Course(@RequestParam(value = "tag1") String tag1) {
        return courseService.selectByTag1Course(tag1);
    }


    //    按照Tag2查找对应的课程
    @ApiOperation(value = "按照Tag2查找对应的课程", notes = "根据Tag2查找对应的Course对象")
    @ApiImplicitParam(name = "tag2", value = "课程Tag2", required = true, paramType = "query", dataType = "String")
    @GetMapping("/tag2")
    public List<Course> selectByTag2Course(@RequestParam(value = "tag2") String tag2) {
        return courseService.selectByTag2Course(tag2);
    }


    //    按照Tag3查找对应的课程
    @ApiOperation(value = "按照Tag3查找对应的课程", notes = "根据Tag3查找对应的Course对象")
    @ApiImplicitParam(name = "tag3", value = "课程Tag3", required = true, paramType = "query", dataType = "String")
    @GetMapping("/tag3")
    public List<Course> selectByTag3Course(@RequestParam(value = "tag3") String tag3) {
        return courseService.selectByTag3Course(tag3);
    }
}
