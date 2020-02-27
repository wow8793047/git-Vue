package com.itheima.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.mappers.UserMapper;
import net.sf.jsqlparser.parser.JJTCCJSqlParserState;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1,2);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //获取分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("当前页数:" + pageInfo.getPageNum());
        System.out.println("每页显示条数:" + pageInfo.getPageSize());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("是否还有下一页:" + pageInfo.isHasNextPage());
        System.out.println("是否是最后一页:" + pageInfo.isIsLastPage());
        System.out.println("上一页页码:" + pageInfo.getPrePage());
        System.out.println("下一页页码:" + pageInfo.getNextPage());
        List<User> list = pageInfo.getList();
    }
}
