package com.mybatis.mapper;

import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.SelectProvider;

public interface IStudentMapperDen {
    @SelectProvider(method = "CritieriaSQL",type = CritieriaSQL.class)
    Student getStudent(Student student);
}
