package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.NoteService;
import com.ysu.wxappstudyplatformspring.pojo.Note;
import com.ysu.wxappstudyplatformspring.pojo.NoteShown;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //    添加笔记
    @ApiOperation(value = "添加笔记", notes = "输入Note对象，创建笔记，返回true")
    @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = true, dataType = "Note")
    @PostMapping("/")
    boolean addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    //    删除指定id笔记
    @ApiOperation(value = "删除笔记", notes = "输入笔记ID id，删除笔记，返回true")
    @ApiImplicitParam(name = "id", value = "准备删除笔记的id", required = true, paramType = "query", dataType = "String")
    @CrossOrigin(origins = "*")
    @DeleteMapping("/")
    boolean deleteByIdNote(@RequestParam int id) {
        return noteService.deleteByIdNote(id);
    }

    //    更新指定id笔记
    @ApiOperation(value = "更新笔记", notes = "输入Note对象，更新笔记，返回true")
    @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = true, dataType = "Note")
    @CrossOrigin(origins = "*")
    @PutMapping("/")
    boolean updateNote(@RequestBody Note note) {
        return noteService.updateNote(note);
    }


    //    查看全部笔记
    @ApiOperation(value = "查看全部笔记", notes = "返回所有Note对象")
//    @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = tr, dataType = "Note")
    @GetMapping("/all")
    List<Note> selectAllNote() {
        return noteService.selectAllNote();
    }

    //    查看某门课所有笔记
    @ApiOperation(value = "查看某门课所有笔记", notes = "输入课程ID Course_id，查找笔记，返回多个Note对象")
    @ApiImplicitParam(name = "course_id", value = "课程course_id", required = true, paramType = "query", dataType = "String")
    @GetMapping("/course-id")
    List<Note> selectByCourse_idNote(@RequestParam String course_id) {
        return noteService.selectByCourse_idNote(course_id);
    }


    //    查看指定id笔记
    @ApiOperation(value = "查看指定id笔记", notes = "输入笔记ID id，查找笔记，返回单个Note对象")
    @ApiImplicitParam(name = "id", value = "笔记id", required = true, paramType = "query", dataType = "String")
    @GetMapping("/id")
    Note selectByIdNote(@RequestParam int id) {
        return noteService.selectByIdNote(id);
    }

    //    查看指定用户的所有笔记
    @ApiOperation(value = "查看指定用户的所有笔记", notes = "输入用户ID unionid，查找笔记，返回多个Note对象")
    @ApiImplicitParam(name = "unionid", value = "用户unionid", required = true, paramType = "query", dataType = "String")
    @GetMapping("/unionid")
    List<NoteShown> selectByUnionidNote(@RequestParam String unionid) {
        return noteService.selectByUnionidNote(unionid);
    }
}
