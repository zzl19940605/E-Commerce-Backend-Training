package com.mercury.SpringBootRestDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.User;
import com.mercury.SpringBootRestDemo.beans.UserInfo;
import com.mercury.SpringBootRestDemo.daos.UserDao;
import com.mercury.SpringBootRestDemo.daos.UserInfoDao;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.http.UserInfoResponse;

@Service
public class UserInfoService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	public Response addUserInfo(UserInfo userInfo, Authentication authentication) {
		User user = userDao.findByUsername(authentication.getName());
		userInfo.setUser(user);
		return new UserInfoResponse(true, userInfoDao.save(userInfo));
	}
	
	public Response updateUserInfo(UserInfo userInfo) {
		UserInfo ud = userInfoDao.findById(userInfo.getId()).get();
		userInfo.setUser(ud.getUser());
		ud = userInfo;
		userInfoDao.save(ud);
		return new Response(true);
	}
}
