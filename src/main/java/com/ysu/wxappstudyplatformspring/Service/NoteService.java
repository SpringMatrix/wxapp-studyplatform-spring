package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.Note;
import com.ysu.wxappstudyplatformspring.pojo.NoteShown;

import java.util.List;

public interface NoteService {

    //    添加笔记
    boolean addNote(Note note);

    //    删除指定id笔记
    boolean deleteByIdNote(int id);

    //    更新指定id笔记
    boolean updateNote(Note note);


    //    查看全部笔记
    List<Note> selectAllNote();

    //    查看某门课所有笔记
    List<Note> selectByCourse_idNote(String course_id);


    //    查看指定id笔记
    Note selectByIdNote(int id);

    //    查看指定用户的所有笔记
    List<NoteShown> selectByUnionidNote(String unionid);




}
