package com.java1234.shiro;


import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class PermissionTest {

	@Test
	public void testIsPermitted() {
		 Subject  currentUser=ShiroUtil.login("classpath:shiro_role.ini","java1234", "123456");
	     System.out.println(currentUser.isPermitted("user:select")?"用户有select权限select":"用户没有权限select");
	     //currentUser.checkPermission("user:select");没有权限抛异常
	}

}
