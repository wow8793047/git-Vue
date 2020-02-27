package com.itheima.mappers;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    User findOne(int id);

    void saveOne(User user);

    List<User> findAll();

    List<User> findByIds(int[] ids);
}
