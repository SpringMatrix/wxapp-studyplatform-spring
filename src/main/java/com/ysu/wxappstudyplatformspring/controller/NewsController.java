package com.ysu.wxappstudyplatformspring.controller;

import com.ysu.wxappstudyplatformspring.Service.NewsService;
import com.ysu.wxappstudyplatformspring.pojo.News;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping(value = "/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    //    添加动态
    @ApiOperation(value = "添加动态",notes = "根据News对象创建动态")
    @ApiImplicitParam(name = "news",value = "动态详细实体news",required = true,dataType = "News")
    @PostMapping("/")
    public boolean addNews(@RequestBody News news) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String str = df.format(now);
        news.setTime(Timestamp.valueOf(str));
        return newsService.addNew(news);
    }




    //    删除指定id动态
    @ApiOperation(value = "删除动态",notes = "删除指定id动态")
    @ApiImplicitParam(name = "id",value = "准备删除动态的id",required = true,paramType = "query",dataType = "int")
    @CrossOrigin(origins = "*")
    @DeleteMapping("/")
    public boolean deleteByIdNews(@RequestParam int id) {
        return newsService.deleteByIdNews(id);
    }



    //    更新指定id动态
    @ApiOperation(value="更新动态", notes="更新指定News对象的动态")
    @ApiImplicitParam(name = "news", value = "动态详细实体news", required = true, dataType = "News")
    @CrossOrigin(origins = "*")
    @PutMapping("/")
    public boolean updateNews( @RequestBody News news) {
        return newsService.updateNews(news);
    }

    @PostMapping("/like")
    public boolean likeNews(@RequestParam int id) {
        News news = newsService.selectByIdNews(id);
        news.setLikenum(news.getLikenum()+1);
        return newsService.updateByIdNewsLikenum(news);
    }

    @PostMapping("/unlike")
    public boolean unlikeNews(@RequestParam int id) {
        News news = newsService.selectByIdNews(id);
        news.setLikenum(news.getLikenum()-1);
        return newsService.updateByIdNewsLikenum(news);
    }





    //    审核通过
    @ApiOperation(value="动态审核通过", notes="管理员审核通过指定id动态")
    @ApiImplicitParam(name = "id", value = "动态id", required = true, paramType = "query",dataType = "int")
    @PutMapping("/check-ok")
    public boolean checkNews_Ok(@RequestParam int id) {
        return newsService.checkNews_Ok(id);
    }



    //    审核不通过
    @ApiOperation(value="动态审核不通过", notes="管理员审核不通过指定id动态")
    @ApiImplicitParam(name = "id", value = "动态id", required = true, paramType = "query",dataType = "int")
    @PutMapping("/check-no")
    public boolean checkNews_No(@RequestParam int id) {
        return newsService.checkNews_No(id);
    }


    //    查看全部动态
    @ApiOperation(value="查看全部动态", notes="查看全部动态")
    @GetMapping("/all")
    public List<News> selectAllNews() {
        return newsService.selectAllNews();
    }





    //    查看指定id动态
    @ApiOperation(value="查看指定id动态", notes="根据动态id来查看指定id动态")
    @ApiImplicitParam(name = "id", value = "动态id", required = true, paramType = "query",dataType = "int")
    @GetMapping("/id")
    public News selectByIdNews(@RequestParam int id) {
        return newsService.selectByIdNews(id);
    }



    //    查看指定用户的所有动态
    @ApiOperation(value="查看指定用户的所有动态", notes="根据unionid来实现查看指定用户的所有动态")
    @ApiImplicitParam(name = "unionid", value = "用户unionid", required = true,paramType = "query", dataType = "String")
    @GetMapping("/unionid")
    public List<News> selectByUnionidNews(@RequestParam String unionid) {
        return newsService.selectByUnionidNews(unionid);
    }




}
