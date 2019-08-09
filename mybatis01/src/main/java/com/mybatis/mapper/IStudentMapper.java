package com.mybatis.mapper;

import com.mybatis.pojo.Student;

import java.util.List;
import java.util.Map;

public interface IStudentMapper {
    public Integer count();
    public Integer count2(int param);
    public Integer count$(Map map);
    public Object[] selectObj();

    int insert(Map map);
    List<Student> getAssosiation();
    List<Student> getLink();
    List<Student> querryQritirea(Student stu);

}
