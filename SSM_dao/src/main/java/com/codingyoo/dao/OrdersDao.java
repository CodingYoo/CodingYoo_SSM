package com.codingyoo.dao;

import com.codingyoo.pojo.Member;
import com.codingyoo.pojo.Orders;
import com.codingyoo.pojo.Product;
import com.codingyoo.pojo.Traveller;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrdersDao {
    //查询订单表，多表操作
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "producid",javaType = Product.class,one = @One(select = "com.codingyoo.dao.IProductDao.findById"))
            })
    List<Orders> findAll();

    //订单详情
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "producid",javaType = Product.class,one = @One(select = "com.codingyoo.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberid",javaType = Member.class,one = @One(select = "com.codingyoo.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,one = @One(select = "com.codingyoo.dao.TravellersDao.findByOrderId"))
    })
    Orders findById(int id);
}
