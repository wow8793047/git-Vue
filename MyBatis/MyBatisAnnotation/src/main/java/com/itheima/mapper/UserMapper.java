package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id=#{userId}")
    User findById(int userId);

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    void addUser(User user);

    @Update("update user set username=#{username} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{userId}")
    void delUser(int userId);

    @Select("select *,o.id oid from user u,orders o where u.id=o.uid")
    List<User> findByuIdUserAndOrder(int userId);


    @Select("select * from user")
    @Results({
            //id:表明该属性对应的数据库字段是id
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    property = "orders",//需要封装的属性名称
                    column = "id",//根据哪个字段去查另一张表
                    javaType = List.class,
                    many = @Many(select = "com.itheima.mapper.OrderMapper.findByUid")
            )
    })
    List<User> findUsersAndOrders();

    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roles",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.itheima.mapper.RoleMapper.findByUserId")
            )
    })
    List<User> findUsersAndRoles();
}
