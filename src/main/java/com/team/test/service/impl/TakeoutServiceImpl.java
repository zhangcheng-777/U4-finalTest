package com.team.test.service.impl;

import com.team.test.entity.Takeout;
import com.team.test.mapper.ProductMapper;
import com.team.test.mapper.TakeoutMapper;
import com.team.test.service.TakeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TakeoutServiceImpl implements TakeoutService {
    @Autowired
    private TakeoutMapper takeoutMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public int outProduct(Takeout takeout) {
        productMapper.outPro(takeout.getQuantity(),takeout.getProductid());
        return takeoutMapper.insertSelective(takeout);
    }
}
