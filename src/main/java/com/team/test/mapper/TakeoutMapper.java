package com.team.test.mapper;

import com.team.test.entity.Takeout;
import com.team.test.entity.TakeoutExample;
import java.util.List;

public interface TakeoutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Takeout record);

    int insertSelective(Takeout record);

    List<Takeout> selectByExample(TakeoutExample example);

    Takeout selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Takeout record);

    int updateByPrimaryKey(Takeout record);
}