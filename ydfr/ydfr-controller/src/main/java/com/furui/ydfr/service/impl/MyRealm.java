package com.furui.ydfr.service.impl;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.furui.ydfr.entity.UserEntity;
import com.furui.ydfr.service.ILoginService;

public class MyRealm  extends AuthorizingRealm{
	
	@Autowired
	private  ILoginService loginService;
    /**
     * @author zoudefu
     * 验证成功后给用户添加角色和权限
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		Set<String>roleSet=loginService.selectUserRole(userName);
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(roleSet);
		authorizationInfo.setStringPermissions(loginService.selectUserRoleRight(roleSet));
		return authorizationInfo;
	}
    /**
     * 验证当前登陆的用户
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
		UserEntity user=loginService.selectUserEntity(userName);
		if(user!=null){
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"myRealm");
			return authcInfo;
		}else{
			return null;		 			
		}
	}

}
