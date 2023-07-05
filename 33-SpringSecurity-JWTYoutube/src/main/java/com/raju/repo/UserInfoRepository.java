package com.raju.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raju.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
	public Optional<UserInfo> findByUsername(String username);

}
