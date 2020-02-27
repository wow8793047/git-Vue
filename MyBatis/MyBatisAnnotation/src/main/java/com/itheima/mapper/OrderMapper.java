package com.itheima.mapper;

import com.itheima.domain.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {


    @Select("select * from orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "uid"),
            @Result(
                    property = "user",  //要封装的属性名称
                    column = "uid" ,//根据哪个字段去查询另一个表的数据
                    javaType = List.class,//要封装的属性类型
                    //select属性:使用哪个接口的方法获取数据
                    one = @One(select = "com.itheima.mapper.UserMapper.findById")
            )
    })
    List<Order> finAllAndUser();

    @Select("select * from orders where uid=#{userId}")
    List<Order> findByUid(int userId);
}
