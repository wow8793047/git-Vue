package com.itheima.mapper;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("select * from sys_role r,sys_user_role ur where r.id=ur.roleId and ur.userId=#{userId}")
    Role findByUserId(int userId);
}
