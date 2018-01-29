package com.java1234.shiro;



import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class ShiroRoleTest {
	
	@Test
	public void testHasRole(){
	 Subject  currentUser=ShiroUtil.login("classpath:shiro_role.ini","java1234", "123456");
	 System.out.println(currentUser.hasRole("role1")?"java1234用户有role1角色":"java1234用户没有role1角色");
	 //currentUser.checkRole("role3");//当前用户有该角色就不报错，没有权限会报错
	 //currentUser.checkRoles(Arrays.asList("role1","role2","role3"));//当前用户有该角色就不报错，没有权限会报错
	 boolean[] results=currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
	 System.out.println(results[0]?"java1234用户有role1角色":"java1234用户没有role1角色");
	 System.out.println(results[1]?"java1234用户有role2角色":"java1234用户没有role2角色");
	 System.out.println(results[2]?"java1234用户有role3角色":"java1234用户没有role3角色");
	 System.out.println(currentUser.hasAllRoles(Arrays.asList("role1","role2","role3"))?"java1234用户有role1,role2,role3角色":"java1234用户没有role1,role2,role3角色");
	 currentUser.logout();
	}

}
