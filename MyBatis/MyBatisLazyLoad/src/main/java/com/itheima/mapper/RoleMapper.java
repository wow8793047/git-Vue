package com.itheima.mapper;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> findByUid(int id);
}
