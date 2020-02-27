package com.itheima.mappers;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    User findById(int id);
}
