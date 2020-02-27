package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper{
    User findById(int id);

    List<User> findAll();
}
