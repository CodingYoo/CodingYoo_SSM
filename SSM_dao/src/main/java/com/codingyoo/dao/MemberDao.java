package com.codingyoo.dao;

import com.codingyoo.pojo.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id = #{id}")
    Member findById(int id);
}
