package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findOne(int id);

    List<User> findCondition(User user);

    List<User> findByIds(int[] ids);
}
