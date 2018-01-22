package com.furui.ydfr.dao;

import com.furui.ydfr.entity.RightEntity;

public interface IRightDao {
    int deleteByPrimaryKey(String id);

    int insert(RightEntity record);

    int insertSelective(RightEntity record);

    RightEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RightEntity record);

    int updateByPrimaryKey(RightEntity record);
}