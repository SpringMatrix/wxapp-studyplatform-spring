package com.ysu.wxappstudyplatformspring.Dao;


import com.ysu.wxappstudyplatformspring.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {

    //    添加动态
    @Insert("insert into news (unionid,name,avatar,content,time) values(#{unionid},#{name},#{avatar},#{content},#{time})")
    boolean addNew(News news);

    //    删除指定id动态
    @Delete("delete from news where id=#{id}")
    boolean deleteByIdNews(int id);

    //    更新指定用户id所有动态的动态名
    @Update("update news set name=#{name} where unionid=#{unionid}")
    boolean updateNews(News news);

    //    更新指定id动态的点赞数量
    @Update("update news set likenum=#{likenum} where id=#{id}")
    boolean updataByIdNewsLikenum(News news);

    //    审核通过
    @Update("update news set visible='1' where id=#{id}")
    boolean checkNews_Ok(int id);

    //    审核不通过
    @Update("update news set visible='0' where id=#{id}")
    boolean checkNews_No(int id);

    //    查看全部动态
    @Select("select * from news order by 'id' DESC")
    List<News> selectAllNews();


    //    查看全部通过审核的动态
    @Select("select * from news where visible=1")
    List<News> selectAllNewsVisible();

    //    查看指定id动态
    @Select("select * from news where id=#{id}")
    News selectByIdNews(int id);

    //    查看指定用户的所有动态
    @Select("select * from news where unionid=#{unionid}")
    List<News> selectByUnionidNews(String unionid);

    //    查看指定用户的所有通过审核动态
    @Select("select * from news where unionid=#{unionid} and visible=1")
    List<News> selectByUnionidNewsVisible(String unionid);
}
