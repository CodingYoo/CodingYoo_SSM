package com.codingyoo.service;

import com.codingyoo.pojo.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();

    List<Orders> findAll(int page, int size);

    Orders findById(int ordersId);
}
