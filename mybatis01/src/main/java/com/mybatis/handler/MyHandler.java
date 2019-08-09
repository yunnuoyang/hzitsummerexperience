package com.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义的handler进行类型转换
 */
public class MyHandler extends BaseTypeHandler<String> {
    Logger logger=Logger.getLogger(MyHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        System.out.println("!!!!!!!"+i+"11111"+s);
//# The error may involve com.mybatis.mapper.IEmpMapper.MyParamHandler
//### The error occurred while setting parameters
//### SQL: insert into(id,name,sex) emp values(?,?,?)
        logger.info("到达了设置参数的方法，快开始吧");
        String value;
        System.out.println(s+"==="+i);
        if("男".equals(s)){
            value="1";
        }else{
            value="0";
        }
        preparedStatement.setString(3,value);
    }

    /**
     *
     * @param resultSet 结果集映射
     * @param s  获取的列名
     * @return
     * @throws SQLException
     */
    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("=======99>"+s);
        int anInt = resultSet.getInt(s);
        return anInt==1?"男":"女";
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("=============>"+i);
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
