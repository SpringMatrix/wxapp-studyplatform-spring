package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.CourseService;
import com.ysu.wxappstudyplatformspring.Service.UserService;
import com.ysu.wxappstudyplatformspring.pojo.Course;
import com.ysu.wxappstudyplatformspring.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;



//    添加课程
    @ApiOperation(value="添加课程", notes="根据Course对象创建课程")
    @ApiImplicitParam(name = "course", value = "课程详细实体course", required = true, dataType = "Course")
    @PostMapping("/add")
    public boolean addCourse(@RequestBody Course course){
        System.out.println("开始添加课程！");
        return courseService.addCourse(course);
    }



//    删除课程

    @ApiOperation(value="删除课程", notes="根据Id删除Course对象")
    @ApiImplicitParam(name = "course_id", value = "课程id号course_id", required = true, dataType = "String")
    @DeleteMapping("/delete")
    public boolean deleteByIdCourse(@RequestParam(value = "course_id") String course_id){
        System.out.println("开始删除课程");
        return courseService.deleteByIdCourse(course_id);
    }





//    更新课程
    @ApiOperation(value="更新课程信息", notes="根据Couerse对象自动获取其中Id并更新对应课程信息")
    @ApiImplicitParam(name = "course", value = "课程course", required = true, dataType = "Course")
    @PutMapping("/update")
    public boolean updateCourse(@RequestBody Course course){
        System.out.println("开始更新课程信息");
        return courseService.updateCourse(course);
    }

//    查找全部课程
    @ApiOperation(value="查找全部课程信息", notes="返回所有Course对象")
//    @ApiImplicitParam(name = "course", value = "课程course", required = false, dataType = "Course")
    @GetMapping("/selectall")
    public List<Course> selectAllCourse(){
        return courseService.selectAllCourse();
    }




//    按照Id查找对应的课程
    @ApiOperation(value="按照Id查找对应的课程", notes="根据Couer_id查找对应的Course对象")
    @ApiImplicitParam(name = "course_id", value = "课程id号course_id", required = true, dataType = "String")
    @GetMapping("/selectbyid")
    public Course selectByIdCourse(@RequestParam(value = "course_id") String course_id){
        return courseService.selectByIdCourse(course_id);
    }





//    按照Tag1查找对应的课程
    @ApiOperation(value="按照Tag1查找对应的课程", notes="根据Tag1查找对应的Course对象")
    @ApiImplicitParam(name = "tag1", value = "课程Tag1", required = true, dataType = "String")
    @GetMapping("/selectbytag1")
    public List<Course> selectByTag1Course(@RequestParam(value = "tag1") String tag1){
        return courseService.selectByTag1Course(tag1);
    }




//    按照Tag2查找对应的课程
    @ApiOperation(value="按照Tag2查找对应的课程", notes="根据Tag2查找对应的Course对象")
    @ApiImplicitParam(name = "tag2", value = "课程Tag2", required = true, dataType = "String")
    @GetMapping("/selectbytag2")
    public List<Course> selectByTag2Course(@RequestParam(value = "tag2") String tag2){
        return courseService.selectByTag2Course(tag2);
    }




//    按照Tag3查找对应的课程
    @ApiOperation(value="按照Tag3查找对应的课程", notes="根据Tag3查找对应的Course对象")
    @ApiImplicitParam(name = "tag3", value = "课程Tag3", required = true, dataType = "String")
    @GetMapping("/selectbytag3")
    public List<Course> selectByTag3Course(@RequestParam(value = "tag3") String tag3){
        return courseService.selectByTag3Course(tag3);
    }
}
