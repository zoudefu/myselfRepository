package com.furui.ydfr.dao;

import com.furui.ydfr.entity.RoleRightRelationEntity;

public interface IRoleRightRelationDao {
    int deleteByPrimaryKey(String id);

    int insert(RoleRightRelationEntity record);

    int insertSelective(RoleRightRelationEntity record);

    RoleRightRelationEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleRightRelationEntity record);

    int updateByPrimaryKey(RoleRightRelationEntity record);
}