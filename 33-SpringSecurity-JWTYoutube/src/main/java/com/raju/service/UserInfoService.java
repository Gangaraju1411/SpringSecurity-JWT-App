package com.raju.service;

import org.springframework.stereotype.Component;

import com.raju.entity.UserInfo;
@Component
public interface UserInfoService {
	
	public String addUser(UserInfo userInfo);

}
