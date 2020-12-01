package com.codingyoo.dao;

import com.codingyoo.pojo.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellersDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findByOrderId(int ordersId);
}
