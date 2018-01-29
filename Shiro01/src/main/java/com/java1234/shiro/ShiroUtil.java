package com.java1234.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {
	
	public static Subject login(String configFile,String uesrName,String password){
		// ��ȡ�����ļ�����ʼ��SecurityManagerg����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		// ��ȡSecurityManger
		SecurityManager securityManager = factory.getInstance();
		// ��securityManagerʵ���󶨵�SecurityUtils(����һ��Ԥ����)
		SecurityUtils.setSecurityManager(securityManager);
		// ��õ�ǰ�û�
		Subject currentUser = SecurityUtils.getSubject();
		// �����û������� �û���������д��
		UsernamePasswordToken token = new UsernamePasswordToken(uesrName,password);
		try {
			currentUser.login(token);
			System.out.println("��½�ɹ�");
		} catch (AuthenticationException e) {
			e.printStackTrace();
		    System.out.println("��½ʧ��");
		}
		return currentUser;
	}
}
