package com.furui.ydfr.dao;

import com.furui.ydfr.entity.DepartmentEntity;

public interface IDepartmentDao {
    int deleteByPrimaryKey(String id);

    int insert(DepartmentEntity record);

    int insertSelective(DepartmentEntity record);

    DepartmentEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DepartmentEntity record);

    int updateByPrimaryKey(DepartmentEntity record);
}