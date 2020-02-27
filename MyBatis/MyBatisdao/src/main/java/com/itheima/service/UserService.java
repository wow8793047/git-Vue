package com.itheima.service;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll() throws IOException;

    User findOne() throws IOException;

    List<User> findCondition(User user) throws IOException;

    List<User> findByIds(int[] ids) throws IOException;
}
