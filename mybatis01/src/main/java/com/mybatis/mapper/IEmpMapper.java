package com.mybatis.mapper;

import com.mybatis.pojo.Emp;

import java.util.List;

public interface IEmpMapper {
    List<Emp> getEmp();
    void addEmp(Emp emp);
}
