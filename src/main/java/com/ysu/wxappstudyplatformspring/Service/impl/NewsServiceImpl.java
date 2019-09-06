package com.ysu.wxappstudyplatformspring.Service.impl;

import com.ysu.wxappstudyplatformspring.Dao.NewsDao;
import com.ysu.wxappstudyplatformspring.Dao.NoteDao;
import com.ysu.wxappstudyplatformspring.Service.NewsService;
import com.ysu.wxappstudyplatformspring.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDao newsDao;

    //    添加动态
    @Override
    public boolean addNew(News news) {
        boolean flag=false;
        try {
            newsDao.addNew(news);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }




    //    删除指定id动态
    @Override
    public boolean deleteByIdNews(int id) {
        boolean flag=false;
        try {
            newsDao.deleteByIdNews(id);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }



    //    更新指定id动态
    @Override
    public boolean updateNews(News news) {
        boolean flag=false;
        try {
            newsDao.updateNews(news);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }





    //    审核通过
    @Override
    public boolean checkNews_Ok(int id) {
        boolean flag=false;
        try {
            newsDao.checkNews_Ok(id);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }



    //    审核不通过
    @Override
    public boolean checkNews_No(int id) {
        boolean flag=false;
        try {
            newsDao.checkNews_No(id);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }


    //    查看全部动态
    @Override
    public List<News> selectAllNews() {
        return newsDao.selectAllNews();
    }





    //    查看指定id动态
    @Override
    public News selectByIdNews(int id) {
        return newsDao.selectByIdNews(id);
    }



    //    查看指定用户的所有动态
    @Override
    public List<News> selectByUnionidNews(String unionid) {
        return newsDao.selectByUnionidNews(unionid);
    }
}
