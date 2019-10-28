package com.team.test.mapper;

import com.team.test.entity.Product;
import com.team.test.entity.ProductExample;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    @Update("update product set quantity=quantity-#{arg0} where id= #{arg1}")
    int outPro(Integer num,Integer id);
}