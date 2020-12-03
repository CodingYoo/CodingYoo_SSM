package com.codingyoo.dao;

import com.codingyoo.pojo.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

public interface UserDao {
    @Select("select * from users where username=${username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "status",column = "status"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.codingyoo.dao.findRoleByUserId"))

    })
    public UserInfo findByUsername(String username);
}
