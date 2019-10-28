package com.team.test.service;

import com.team.test.entity.Product;

import java.util.List;

public interface ProductService {
    //查询所有商品信息
    List<Product> getAllProduct();

    Product selectQuantity(Integer id);

    //出库减少库存
    int out(Integer num,Integer id);
}
