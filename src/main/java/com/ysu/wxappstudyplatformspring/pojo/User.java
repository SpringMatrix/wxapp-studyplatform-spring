package com.ysu.wxappstudyplatformspring.pojo;

import java.sql.Date;

public class User {

    private String unionid;
    private String name;
    private String sex;
    private String privacy;
    private String tag;
    private String follow_num;
    private Date punch_time;

    public Date getPunch_time() {
        return punch_time;
    }

    public void setPunch_time(Date punch_time) {
        this.punch_time = punch_time;
    }

    public String getUnionid() {
        return unionid;

    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFollow_num() {
        return follow_num;
    }

    public void setFollow_num(String follow_num) {
        this.follow_num = follow_num;
    }
}
