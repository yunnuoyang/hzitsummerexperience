package com.mybatis.mapper;

import com.mybatis.pojo.Student;
import org.apache.ibatis.jdbc.SQL;

import static org.apache.ibatis.jdbc.SelectBuilder.*;

public class CritieriaSQL {
    public String CritieriaSQL(Student student){
      return new SQL() {{
            SELECT("sname");
            SELECT("sno");
            FROM("student");
            if(student.getSname()!=null) {
                WHERE("sname like #{sname}");
            }
            ORDER_BY("sno desc");
        }}.toString();

    }
}
abstract class a{
    public a() {
        b();
    }
    public void b(){
        System.out.println("111111");
    };
}
class B extends a{
    public B() {
        super();
    }

    public static void main(String[] args) {
        B b=new B();
    }
}
