package com.mybatis.pojo;

public class Student {
    private Integer sno;
    private String sname;
    private Integer scid;
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Integer getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
