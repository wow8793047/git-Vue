package com.itheima.hanlder;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TypeHanlder extends BaseTypeHandler<Date> {

    //Java类型转为数据库类型
    //参数: date:存入数据库的java类型Date  i:表中字段位置
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }
    //数据库类型转为java类型
    //resultSet:查询到的结果集, s:java类型转为数据库类型对应字段的字段名
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long aLong = resultSet.getLong(s);
        return new Date(aLong);
    }
    //数据库类型转为java类型
    //resultSet:查询到的结果集, i:java类型转为数据库类型对应字段的位置
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }
    //数据库类型转为java类型
    //callableStatement:查询到的结果集, i:java类型转为数据库类型对应字段的字段位置
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }
}
