package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserController {
    private UserService userService = new UserServiceImpl();

    @Test
    public void test1() throws IOException {
        List<User> users = userService.findAll();
        System.out.println(users);
    }

    @Test
    public void test2() throws IOException {
        User user = userService.findOne();
        System.out.println(user);
    }

    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(2);
        //user.setUsername("zhangsan");
        //user.setPassword("123");
        List<User> users = userService.findCondition(user);
        System.out.println(users);
    }

    @Test
    public void test4() throws IOException {
        int[] ids = {1,2};
        List<User> users = userService.findByIds(ids);
        System.out.println(users);
    }

}
