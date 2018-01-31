package com.furui.ydfr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furui.ydfr.dao.IRightDao;
import com.furui.ydfr.dao.IRoleDao;
import com.furui.ydfr.dao.IUserDao;
import com.furui.ydfr.entity.UserEntity;
import com.furui.ydfr.service.imp.ILoginService;

@Service
public class LoginService implements ILoginService {
	
	Logger logger=LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRightDao rightDao;
	@Autowired
	private IRoleDao roleDao;

	@Override
	public Map<String, String> insertUserList(List<UserEntity> userList) {
		Map<String, String> map = new HashMap<>();
		int i = userDao.insertUserList(userList);
		if (i > 0) {
			map.put("message", "用户信息插入成功");
			map.put("code", "500");
		} else {
			map.put("message", "用户信息插入失败");
			map.put("code", "200");
		}
		return map;
	}

	@Override
	public Map<String, String> selectUser(String username, String password) {
		Map<String, String> map = new HashMap<>();
		List<UserEntity> user=userDao.selectUser(username,password);
		if(user.size()>0){
			logger.error("测试日志和数据库调用");
		}
		map.put("message", "用户信息插入成功");
		map.put("code", "500");
		return map;
	}
	@Override
	public UserEntity selectUserEntity(String userName){
		return userDao.selectUserEntity(userName);
	}

	@Override
	public Set<String> selectUserRoleRight(  Set<String> roleIdList) {
		return rightDao.selectUserRoleRight(roleIdList);
	}

	@Override
	public Set<String> selectUserRole(String userName) {
		return roleDao.selectUserRole(userName);
	} 
}
