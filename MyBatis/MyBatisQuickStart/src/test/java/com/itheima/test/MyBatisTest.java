package com.itheima.test;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test1() throws IOException {
        //加载mybatis核心文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取连接mysql工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //打开一连接
        SqlSession sqlSession = sessionFactory.openSession();
        //执行操作  参数:映射文件命名空间+sql映射配置id
        List<User> users = sqlSession.selectList("userMapper.findAll",1);
        System.out.println(users);
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //加载mybatis核心文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取连接mysql工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //打开一连接
        SqlSession sqlSession = sessionFactory.openSession();
        //执行操作  参数:映射文件命名空间+sql映射配置id
        User user = new User();
        user.setId(3);
        user.setUsername("wangwu");
        user.setPassword("312");
        sqlSession.insert("userMapper.saveUser", user);
        //提交事务
        sqlSession.commit();
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //加载mybatis核心文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取连接mysql工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //打开一连接
        SqlSession sqlSession = sessionFactory.openSession();
        //执行操作  参数:映射文件命名空间+sql映射配置id
        User user = new User();
        user.setId(3);
        user.setUsername("777");
        user.setPassword("777");
        sqlSession.update("userMapper.updateUser",user);
        //提交事务
        sqlSession.commit();
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        //加载mybatis核心文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取连接mysql工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //打开一连接
        SqlSession sqlSession = sessionFactory.openSession(true);
        //执行操作  参数:映射文件命名空间+sql映射配置id
        sqlSession.delete("userMapper.deleteUser",1);
        //关闭连接
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        //加载mybatis核心文件
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取连接mysql工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //打开一连接
        SqlSession sqlSession = sessionFactory.openSession();
        //执行操作  参数:映射文件命名空间+sql映射配置id
        Object o = sqlSession.selectOne("userMapper.findById", 1);
        System.out.println(o);
        //关闭连接
        sqlSession.close();
    }
}
