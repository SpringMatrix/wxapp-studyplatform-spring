package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.NoteService;
import com.ysu.wxappstudyplatformspring.pojo.Note;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //    添加笔记
    @ApiOperation(value="添加笔记", notes="根据Note对象创建笔记")
    @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = true, dataType = "Note")
    @PostMapping("/add")
    boolean addNote(Note note){
        return noteService.addNote(note);
    }

    //    删除指定id笔记
    @ApiOperation(value = "删除笔记",notes = "删除指定id笔记")
    @ApiImplicitParam(name = "id",value = "准备删除笔记的id",required = true,dataType = "String")
    @DeleteMapping("/delete")
    boolean deleteByIdNote(int id){
        return noteService.deleteByIdNote(id);
    }

    //    更新指定id笔记
    @ApiOperation(value="更新笔记", notes="更新指定Note对象的笔记")
    @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = true, dataType = "Note")
    @PutMapping("/update")
    boolean updateNote(Note note){
        return noteService.updateNote(note);
    }


    //    查看全部笔记
    @ApiOperation(value="查看全部笔记", notes="查看全部笔记")
//    @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = tr, dataType = "Note")
    @GetMapping("/selectall")
    List<Note> selectAllNote(){
        return noteService.selectAllNote();
    }

    //    查看某门课所有笔记
    @ApiOperation(value="查看某门课所有笔记", notes="根据Course_id查找某门课的所有笔记")
    @ApiImplicitParam(name = "course_id", value = "课程course_id", required = true, dataType = "String")
    @GetMapping("/selectbycourse_id")
    List<Note> selectByCourse_idNote(String course_id){
        return selectByCourse_idNote(course_id);
    }


    //    查看指定id笔记
    @ApiOperation(value="查看指定id笔记", notes="根据笔记id来查看指定id笔记")
    @ApiImplicitParam(name = "id", value = "笔记id", required = true, dataType = "String")
    @GetMapping("/selectbyid")
    Note selectByIdNote(int id){
        return noteService.selectByIdNote(id);
    }

    //    查看指定用户的所有笔记
    @ApiOperation(value="查看指定用户的所有笔记", notes="根据unionid来实现查看指定用户的所有笔记")
    @ApiImplicitParam(name = "", value = "用户unionid", required = true, dataType = "String")
    @GetMapping("/selectbyunionid")
    List<Note> selectByUnionidNote(String unionid){
        return noteService.selectByUnionidNote(unionid);
    }
}
