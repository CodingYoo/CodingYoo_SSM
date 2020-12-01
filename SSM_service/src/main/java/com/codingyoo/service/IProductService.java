package com.codingyoo.service;

import com.codingyoo.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    //查询所有产品
    public List<Product> findAll() throws Exception;
    //保存产品
    void save(Product product);
}
