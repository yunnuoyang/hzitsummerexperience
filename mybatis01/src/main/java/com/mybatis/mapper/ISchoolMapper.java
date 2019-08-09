package com.mybatis.mapper;

import com.mybatis.pojo.School;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface ISchoolMapper {
    List<School> getSchoolByOrder();
    List<School> getUnderStudentsOfSchool();
    @Options(useGeneratedKeys =true,keyProperty = "scid")
    public List<School> find();
}
