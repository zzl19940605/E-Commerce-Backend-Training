package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mercury.SpringBootRestDemo.beans.UserInfo;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.UserInfoService;

@RestController
@RequestMapping("/user-details")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	

	@PostMapping
	public Response postUserDetails(@RequestBody UserInfo userInfo, Authentication authentication) {
		return userInfoService.addUserInfo(userInfo, authentication);
	}
	
	@PutMapping
	public Response putUserInfos(@RequestBody UserInfo userInfo) {
		return userInfoService.updateUserInfo(userInfo);
	}
	
}
