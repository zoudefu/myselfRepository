package com.furui.ydfr.dao;

import com.furui.ydfr.entity.UserRoleRelationEntity;

public interface IUserRoleRelationDao {
    int deleteByPrimaryKey(String id);

    int insert(UserRoleRelationEntity record);

    int insertSelective(UserRoleRelationEntity record);

    UserRoleRelationEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleRelationEntity record);

    int updateByPrimaryKey(UserRoleRelationEntity record);
}