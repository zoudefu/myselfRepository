package com.java1234.shiro;


import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class PermissionTest {

	@Test
	public void testIsPermitted() {
		 Subject  currentUser=ShiroUtil.login("classpath:shiro_role.ini","java1234", "123456");
	     System.out.println(currentUser.isPermitted("user:select")?"�û���selectȨ��select":"�û�û��Ȩ��select");
	     //currentUser.checkPermission("user:select");û��Ȩ�����쳣
	}

}
