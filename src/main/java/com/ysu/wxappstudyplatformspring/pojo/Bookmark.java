package com.ysu.wxappstudyplatformspring.pojo;

import java.awt.print.Book;

public class Bookmark {
    private String id;
    private String unionid;
    private String course_id;

    public Bookmark() {
        id = "0";
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

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
