package com.furui.ydfr.dao;

import java.util.List;


import com.furui.ydfr.entity.UserEntity;

public interface IUserDao {
	/**
	 * 批量插入用户信息
	 * @param userList
	 * @return
	 */
	public int  insertUserList(List<UserEntity> userList);
    /**
     * 查询用户基本信息
     * @param username
     * @param password
     * @return
     */
	public List<UserEntity> selectUser(String username,String password);
	/**
	 * 根据用户登录账号查询用户信息
	 * @param userName
	 * @return
	 */
	public UserEntity selectUserEntity(String userName); 
}
