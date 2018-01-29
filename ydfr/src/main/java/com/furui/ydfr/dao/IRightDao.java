package com.furui.ydfr.dao;

import java.util.List;
import java.util.Set;

import com.furui.ydfr.entity.RightEntity;

public interface IRightDao {
	
	public int deleteByPrimaryKey(String id);

    public int insert(RightEntity record);

    public int insertSelective(RightEntity record);

    public RightEntity selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(RightEntity record);

    public int updateByPrimaryKey(RightEntity record);
    /**
	 * 根据角色id查询，权限信息
	 * @param roleIdList
	 * @return
	 */
	public Set<String> selectUserRoleRight(Set<String> roleIdList);
}