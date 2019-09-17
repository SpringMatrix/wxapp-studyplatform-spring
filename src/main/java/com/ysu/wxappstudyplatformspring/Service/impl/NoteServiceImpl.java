package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.NoteDao;
import com.ysu.wxappstudyplatformspring.Service.NoteService;
import com.ysu.wxappstudyplatformspring.pojo.Note;
import com.ysu.wxappstudyplatformspring.pojo.NoteShown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteDao noteDao;

    @Override
    public boolean addNote(Note note) {
        boolean flag=false;
        try {
            noteDao.addNote(note);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteByIdNote(int id) {
        boolean flag=false;
        try {
            noteDao.deleteByIdNote(id);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateNote(Note note) {
        boolean flag=false;
        try {
            noteDao.updateNote(note);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Note> selectAllNote() {
        return noteDao.selectAllNote();
    }

    @Override
    public List<Note> selectByCourse_idNote(String course_id) {
        return noteDao.selectByCourse_idNote(course_id);
    }

    @Override
    public Note selectByIdNote(int id) {
        return noteDao.selectByIdNote(id);
    }

    @Override
    public List<NoteShown> selectByUnionidNote(String unionid) {
        return noteDao.selectByUnionidNote(unionid);
    }
}
