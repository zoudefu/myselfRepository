package com.furui.ydfr.dao;

import com.furui.ydfr.entity.RoleEntity;

public interface IRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
}