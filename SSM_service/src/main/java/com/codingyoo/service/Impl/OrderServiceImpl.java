package com.codingyoo.service.Impl;

import com.codingyoo.dao.OrdersDao;
import com.codingyoo.pojo.Orders;
import com.codingyoo.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDao ordersDao;

    //未分页
    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    //已分页
    @Override
    public List<Orders> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    //订单查询
    @Override
    public Orders findById(int ordersId) {
        return ordersDao.findById(ordersId);
    }
}
