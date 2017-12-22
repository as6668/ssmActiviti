package com.dao;

import java.util.List;

import com.entity.user;

public interface IUserDao {
 void add(user use);
 void update(user use);
 void delete(String id);
 user findbyid(String id);
 user findbyname(String username);
 List<user> findAll();
}
