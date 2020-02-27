package com.itheima.mapper;

import com.itheima.domain.User;

public interface UserMapper {
    User findById(int id);
    void delUserById(int id);
    void delSysUserRoleByUserId(int id);
}
