package com.furui.ydfr.dao;

import java.util.List;

import com.furui.ydfr.entity.UserEntity;

public interface UserDao {
	/**
	 * 批量插入用户信息
	 * @param userList
	 * @return
	 */
	public int  insertUserList(List<UserEntity> userList);
    /**
     * 查询用户基本信息
     * @return
     */
	public List<UserEntity> selectUser(String username,String password);
}
