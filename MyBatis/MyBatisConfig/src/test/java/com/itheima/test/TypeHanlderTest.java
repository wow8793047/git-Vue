package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TypeHanlderTest {


    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setUsername("zhaosi");
        u.setPassword("123");
        u.setBirthday(new Date());
        mapper.saveOne(u);
        User user = mapper.findOne(8);
        System.out.println(user);
    }
}
