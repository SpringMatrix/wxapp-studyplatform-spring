package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.NoteDao;
import com.ysu.wxappstudyplatformspring.Service.NewsService;
import com.ysu.wxappstudyplatformspring.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsServiceImpl implements NewsService{

    @Autowired
    private NoteDao noteDao;
    @Override
    public boolean addNew(News news) {
        return false;
    }

    @Override
    public boolean deleteByIdNews(int id) {
        return false;
    }

    @Override
    public boolean updateNews(News news) {
        return false;
    }

    @Override
    public boolean checkNote_Ok(String id) {
        return false;
    }

    @Override
    public boolean checkNote_No(String id) {
        return false;
    }

    @Override
    public List<News> selectAllNews() {
        return null;
    }

    @Override
    public News selectByIdNews(int id) {
        return null;
    }

    @Override
    public List<News> selectByUnionidNews(String unionid) {
        return null;
    }
}
