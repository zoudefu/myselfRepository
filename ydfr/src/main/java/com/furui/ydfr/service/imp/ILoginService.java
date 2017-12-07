package com.furui.ydfr.service.imp;

import java.util.List;
import java.util.Map;

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

}
