package com.furui.ydfr.dao;

import java.util.Set;

import com.furui.ydfr.entity.RoleEntity;

public interface IRoleDao {
	
    public   int deleteByPrimaryKey(String id);

    public   int insert(RoleEntity record);

    public   int insertSelective(RoleEntity record);

    public  RoleEntity selectByPrimaryKey(String id);

    public   int updateByPrimaryKeySelective(RoleEntity record);

    public   int updateByPrimaryKey(RoleEntity record);
    
    /**
	 * 根据用户登录账号查询用的角色
	 * @param userName
	 * @return
	 */
	public Set<String> selectUserRole(String userName);
}