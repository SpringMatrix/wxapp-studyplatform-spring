package com.ysu.wxappstudyplatformspring.Dao;

import com.ysu.wxappstudyplatformspring.pojo.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteDao {

//    添加笔记
    @Insert("insert into note (unionid,course_id,content} values(#{unionid},#{course_id},#{content})")
    boolean addNote(Note note);

//    删除指定id笔记
    @Delete("delete from note where id=#{id}")
    boolean deleteByIdNote(int id);

//    更新指定id笔记
    @Update("update note set content=#{content} where id=#{id}")
    boolean updateNote(Note note);


//    查看全部笔记
    @Select("select * from note")
    List<Note> selectAllNote();

//    查看某门课所有笔记
    @Select("select * from note where course_id=#{course_id}")
    List<Note> selectByCourse_idNote(String course_id);


//    查看指定id笔记
    @Select("select * from note where id=#{id}")
    Note selectByIdNote(int id);

//    查看指定用户的所有笔记
    @Select("select * from note where unionid=#{unionid}")
    List<Note> selectByUnionidNote(String unionid);
}
