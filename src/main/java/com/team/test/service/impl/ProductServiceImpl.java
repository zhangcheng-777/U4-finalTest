package com.team.test.service.impl;

import com.team.test.entity.Product;
import com.team.test.entity.ProductExample;
import com.team.test.mapper.ProductMapper;
import com.team.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public Product selectQuantity(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int out(Integer num, Integer id) {
        return productMapper.outPro(num,id);
    }




}
