package com.furui.ydfr.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.furui.ydfr.entity.UserEntity;

public interface ILoginService {
	/**
	 * 插入用户新信息
	 * @param userList
	 * @return
	 */
	public Map<String,String> insertUserList(List<UserEntity>  userList);
	/**
	 * 查询用户信息
	 * @param uesrname
	 * @param password
	 * @return
	 */
	public Map<String, String> selectUser(String uesrname,String password);
	/**
	 * 根据用户登录账号查询用户信息
	 * @param userName
	 * @return
	 */
	public UserEntity selectUserEntity(String userName); 
	/**
	 * 根据角色id查询，权限信息
	 * @param roleIdList
	 * @return
	 */
	public Set<String> selectUserRoleRight(Set<String> roleIdList);
	/**
	 * 根据用户登录账号查询用的角色
	 * @param userName
	 * @return
	 */
	public Set<String> selectUserRole(String userName);

}
