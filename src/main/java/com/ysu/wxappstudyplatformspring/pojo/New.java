package com.ysu.wxappstudyplatformspring.pojo;

import java.sql.Date;

public class New {

    private String id;
    private String unionid;
    private String content;
    private Date date;
    private boolean visible;

    public New(){
        date = new Date(System.currentTimeMillis());
        visible=true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
