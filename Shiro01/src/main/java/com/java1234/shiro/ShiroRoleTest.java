package com.java1234.shiro;



import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class ShiroRoleTest {
	
	@Test
	public void testHasRole(){
	 Subject  currentUser=ShiroUtil.login("classpath:shiro_role.ini","java1234", "123456");
	 System.out.println(currentUser.hasRole("role1")?"java1234�û���role1��ɫ":"java1234�û�û��role1��ɫ");
	 //currentUser.checkRole("role3");//��ǰ�û��иý�ɫ�Ͳ�����û��Ȩ�޻ᱨ��
	 //currentUser.checkRoles(Arrays.asList("role1","role2","role3"));//��ǰ�û��иý�ɫ�Ͳ�����û��Ȩ�޻ᱨ��
	 boolean[] results=currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
	 System.out.println(results[0]?"java1234�û���role1��ɫ":"java1234�û�û��role1��ɫ");
	 System.out.println(results[1]?"java1234�û���role2��ɫ":"java1234�û�û��role2��ɫ");
	 System.out.println(results[2]?"java1234�û���role3��ɫ":"java1234�û�û��role3��ɫ");
	 System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2","role3"))?"java1234�û���role1,role2,role3��ɫ":"java1234�û�û��role1,role2,role3��ɫ");
	 currentUser.logout();
	}

}
