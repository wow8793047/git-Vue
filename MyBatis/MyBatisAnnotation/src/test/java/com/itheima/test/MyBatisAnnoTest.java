package com.itheima.test;

import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisAnnoTest {
    private UserMapper userMapper;
    private OrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        userMapper = factory.openSession(true).getMapper(UserMapper.class);
        orderMapper = factory.openSession(true).getMapper(OrderMapper.class);
    }

    @Test
    public void test1(){
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void test3(){
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123");
        userMapper.addUser(user);
    }

    @Test
    public void test4(){
        User user = new User();
        user.setId(1);
        user.setUsername("wangwu");
        userMapper.updateUser(user);
    }


    @Test
    public void test5(){
        List<Order> order = orderMapper.finAllAndUser();
        System.out.println(order);
    }

    @Test
    public void test6(){
        List<User> usersAndOrders = userMapper.findUsersAndOrders();
        System.out.println(usersAndOrders);
    }

    @Test
    public void test7(){
        List<User> usersAndRoles= userMapper.findUsersAndRoles();
        System.out.println(usersAndRoles);
    }

}
