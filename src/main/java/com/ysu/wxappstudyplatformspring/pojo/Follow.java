package com.ysu.wxappstudyplatformspring.pojo;

public class Follow {
    private int id;
    private String unionid1;
    private String unionid2;

    public Follow() {
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnionid1() {
        return unionid1;
    }

    public void setUnionid1(String unionid1) {
        this.unionid1 = unionid1;
    }

    public String getUnionid2() {
        return unionid2;
    }

    public void setUnionid2(String unionid2) {
        this.unionid2 = unionid2;
    }
}
