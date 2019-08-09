package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class School {
    private Integer scid;
    private String scname;

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    private List<Student> student;

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Integer getScid() {
        return scid;
    }

    public  School() {
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

}
