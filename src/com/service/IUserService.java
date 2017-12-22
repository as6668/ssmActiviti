package com.service;

import java.util.List;

import com.entity.user;

public interface IUserService {
	 void add(user use);
	 void update(user use);
	 void delete(String id);
	 user findbyid(String id);
	 List<user> findAll();
	 user login(String username,String password);
		user findbyname(String username);
}
