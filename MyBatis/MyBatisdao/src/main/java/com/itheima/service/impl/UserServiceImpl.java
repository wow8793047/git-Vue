package com.itheima.service.impl;

import com.itheima.mapper.UserMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {

    public List<User> findAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        sqlSession.close();
        return users;
    }

    public User findOne() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findOne(1);
        sqlSession.close();
        return user;
    }


    public List<User> findCondition(User user) throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findCondition(user);
        sqlSession.close();
        return users;
    }

    public List<User> findByIds(int[] ids) throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByIds(ids);
        sqlSession.close();
        return users;
    }


}
