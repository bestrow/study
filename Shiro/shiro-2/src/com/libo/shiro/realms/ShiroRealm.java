package com.libo.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

public class ShiroRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1. ��AuthenticationToken ת��Ϊ UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		// 2. ��UsernamePasswordToken�л�ȡusername
		String username = upToken.getUsername();
		
		// 3. �������ݿ�ķ����������ݿ��в�ѯusername��Ӧ���û���¼
		System.out.println("�����ݿ��л�ȡusername��"+username+"����Ӧ���û���Ϣ.");
		
		// 4. ���û������ڣ�������׳�UnknownAccountException�쳣
		if ("unknown".equals(username)) {
			throw new UnknownAccountException("�û������ڣ�");
		}
		
		// 5. �����û���Ϣ������������Ƿ���Ҫ�׳�������AuthenticationException�쳣
		if ("monster".equals(username)) {
			throw new LockedAccountException("�û���������");
		}		
		
		// 6.�����û��������������AuthenticationInfo���󲢷���.ͨ��ʹ�õ�ʵ����Ϊ��SimpleAuthenticationInfo
		// ������Ϣ�Ǵ����ݿ��л�ȡ��
		// 1).principal:��֤��ʵ����Ϣ. ������username��Ҳ���������ݱ��Ӧ���û���ʵ�������
		Object principal = username;
		// 2).credentials:����.
		Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		// 3).realmName:��ǰrealm�����name. ���ø����getName()��������
		String realmName = getName();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal , credentials , realmName);
		return info;
	}

	/*public static void main(String[] args) {
		String hashAlgorithmName ="MD5";
		Object credentials = "123456";
		Object salt =null;
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}*/
}
