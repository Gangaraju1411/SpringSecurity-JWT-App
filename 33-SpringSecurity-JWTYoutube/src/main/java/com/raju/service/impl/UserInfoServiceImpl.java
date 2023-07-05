package com.raju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raju.entity.UserInfo;
import com.raju.repo.UserInfoRepository;
import com.raju.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	boolean flag;
	@Override
	public String addUser(UserInfo userInfo) {
		
		List<UserInfo> userList = repository.findAll();
		
		if(null != userList) {
			for(UserInfo user : userList) {
				if(user.getUsername().equals(userInfo.getUsername()))
					flag = true;
				else
					flag = false;
			}
		}
		
		if(flag) {
			return "User already exists";
		} else {
			userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			repository.save(userInfo);
			return "User saved";
		}
	}
}
