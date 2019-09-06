package com.ysu.wxappstudyplatformspring.pojo;

public class Course {
    private int course_id;
    private String unionid;
    private String name;
    private String introduction;
    private String url;
    private String tag1;
    private String tag2;
    private String tag3;
    private String play_num;
    private String bookmark_num;
    private boolean visible;

    public Course(){
        visible=true;
    }


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getPlay_num() {
        return play_num;
    }

    public void setPlay_num(String play_num) {
        this.play_num = play_num;
    }

    public String getBookmark_num() {
        return bookmark_num;
    }

    public void setBookmark_num(String bookmark_num) {
        this.bookmark_num = bookmark_num;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
