package com.codingyoo.dao;

import com.codingyoo.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from roles where id in (select * from user_role where roleId = #{userId})")
    List<Role> findRoleByUserId(int id);
}
