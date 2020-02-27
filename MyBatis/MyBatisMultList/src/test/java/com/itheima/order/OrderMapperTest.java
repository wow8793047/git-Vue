package com.itheima.order;

import com.itheima.domain.Order;
import com.itheima.domain.Sys_user;
import com.itheima.domain.User;
import com.itheima.mappers.OrderMapper;
import com.itheima.mappers.Sys_userMapper;
import com.itheima.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderMapperTest {

    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.findAll();
        System.out.println(orders);
    }

    @Test
    public void test2() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        Sys_userMapper sys_userMapper = sqlSession.getMapper(Sys_userMapper.class);
        List<Sys_user> sys_users = sys_userMapper.findAll();
        for (Sys_user sys_user : sys_users) {
            System.out.println(sys_user);
        }
    }


    @Test
    public void test4() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.findAll();
    }
}
