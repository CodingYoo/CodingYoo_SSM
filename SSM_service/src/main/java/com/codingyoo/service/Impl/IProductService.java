package com.codingyoo.service.Impl;

import com.codingyoo.dao.IProductDao;
import com.codingyoo.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProductService implements com.codingyoo.service.IProductService {

    @Autowired
    private IProductDao iProductDao;
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> productList = iProductDao.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
     iProductDao.save(product);
    }
}
