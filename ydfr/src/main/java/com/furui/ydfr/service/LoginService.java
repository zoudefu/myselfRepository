package com.furui.ydfr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furui.ydfr.dao.UserDao;
import com.furui.ydfr.entity.UserEntity;
import com.furui.ydfr.service.imp.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private UserDao userDao;

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
			map.put("message", "用户信息插入成功");
			map.put("code", "500");


		return map;
	}
}
