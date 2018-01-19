package com.java1234.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class JdbcRealmTest {

	public static void main(String[] args) {
		// 读取配置文件，初始化SecurityManagerg工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc.shiro.ini");
		// 获取SecurityManger
		SecurityManager securityManager = factory.getInstance();
		// 把securityManager实例绑定到SecurityUtils(配置一下预处理)
		SecurityUtils.setSecurityManager(securityManager);
		// 获得当前用户
		Subject currentUser = SecurityUtils.getSubject();
		// 创建用户的令牌 用户名和密码写死
		UsernamePasswordToken token = new UsernamePasswordToken("java1234", "123456");
		try {
			currentUser.login(token);
			System.out.println("登陆成功");
		} catch (AuthenticationException e) {
			e.printStackTrace();
		    System.out.println("登陆失败");
		}
		//用户退出登陆
		currentUser.logout();
		
	}



}
