package com.raju.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.raju.dto.UserInfoUserDetails;
import com.raju.entity.UserInfo;
import com.raju.repo.UserInfoRepository;
@Component
public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private UserInfoRepository repository;
	   @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserInfo> userInfo = repository.findByUsername(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }
}