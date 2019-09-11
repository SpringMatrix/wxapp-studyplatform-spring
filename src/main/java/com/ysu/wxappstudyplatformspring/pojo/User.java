package com.ysu.wxappstudyplatformspring.pojo;

import java.sql.Date;

public class User {

    private String unionid;
    private String name;
    private String sex;
    private boolean privacy;
    private String tag;
    private int follow_num;
    private Date punch_time;
    private int point;
    private String avatar;

    public User() {
        name = "undefined";
        sex = "保密";
        privacy = false;
        follow_num = 0;
        point = 0;
        //punch_time = new Date(System.currentTimeMillis());
    }

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

    public boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getFollow_num() {
        return follow_num;
    }

    public void setFollow_num(int follow_num) {
        this.follow_num = follow_num;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAvatar(){
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
