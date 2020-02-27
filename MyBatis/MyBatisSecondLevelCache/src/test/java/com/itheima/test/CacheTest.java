package com.itheima.test;

import com.itheima.mapper.SysUserMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {
    
    private SqlSession sqlSession1;
    private SqlSession sqlSession2;
    private SqlSession sqlSession3;
    
    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession1 = factory.openSession();
        sqlSession2 = factory.openSession();
        sqlSession3 = factory.openSession();
    }    
    
    @Test
    public void test1(){
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        System.out.println(mapper1.findById(1));
        sqlSession1.close();
        SysUserMapper mapper2 = sqlSession2.getMapper(SysUserMapper.class);
        mapper2.delSysUserById(4);
        sqlSession2.commit();
        sqlSession2.close();
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        System.out.println(mapper3.findById(1));
        sqlSession3.close();
    }
}
