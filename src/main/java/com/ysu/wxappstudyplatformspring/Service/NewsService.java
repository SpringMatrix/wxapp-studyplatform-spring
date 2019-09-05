package com.ysu.wxappstudyplatformspring.Service;

import com.ysu.wxappstudyplatformspring.pojo.News;

import java.util.List;

public interface NewsService {
    //    添加动态
    boolean addNew(News news);

    //    删除指定id动态
    boolean deleteByIdNews(int id);

    //    更新指定id动态
    boolean updateNews(News news);

    //    审核通过
    boolean checkNote_Ok(String id);

    //    审核不通过
    boolean checkNote_No(String id);

    //    查看全部动态
    List<News> selectAllNews();


    //    查看指定id动态
    News selectByIdNews(int id);

    //    查看指定用户的所有动态
    List<News> selectByUnionidNews(String unionid);



}
