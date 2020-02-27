package com.itheima;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    private UserMapper userMapper;
    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        userMapper = new SqlSessionFactoryBuilder().build(is).openSession().getMapper(UserMapper.class);
    }


    @org.junit.Test
    public void test2(){
        List<User> all = userMapper.findAll();
    }
}
