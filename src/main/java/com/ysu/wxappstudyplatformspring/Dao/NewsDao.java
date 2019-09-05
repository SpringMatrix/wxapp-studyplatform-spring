package com.ysu.wxappstudyplatformspring.Dao;


import com.ysu.wxappstudyplatformspring.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {

    //    添加动态
    @Insert("insert into news (unionid,content,visible}} values(#{unionid},#{content},0)")
    boolean addNew(News news);

    //    删除指定id动态
    @Delete("delete from news where id=#{id}")
    boolean deleteByIdNews(int id);

    //    更新指定id动态
    @Update("update news set content=#{content}  where id=#{id}")
    boolean updateNews(News news);

//    审核通过
    @Update("update news set visible='1' where id=#{id}")
    boolean checkNote_Ok(String id);

    //    审核不通过
    @Update("update news set visible='0' where id=#{id}")
    boolean checkNote_No(String id);

    //    查看全部动态
    @Select("select * from news")
    List<News> selectAllNews();


    //    查看指定id动态
    @Select("select * from news where id=#{id}")
    News selectByIdNews(int id);

    //    查看指定用户的所有动态
    @Select("select * from news where unionid=#{unionid}")
    List<News> selectByUnionidNews(String unionid);
}
