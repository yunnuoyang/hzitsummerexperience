package com.mybatis.mapper;

import com.mybatis.pojo.School;
import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface ISchoolAnnoMapper {
    @Select("select * from school where scid=#{scid}")
     List<School> getSchool(Integer scid);
    //#{scid}里边的属性值与pojo类的写法一致
     @Insert("INSERT INTO SCHOOL(scname) VALUES(#{scname})")
     @Options(useGeneratedKeys = true, keyProperty = "scid")
     void save(School school);
}
