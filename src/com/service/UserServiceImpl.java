package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IUserDao;
import com.entity.user;
import com.util.CommonUtil;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao dao;
	@Override
	public void add(user use) {
		if (use!=null) {
			if (use.getId()==null||"".equals(use.getId())) {
				use.setId(CommonUtil.getUUID());
			}
			
		}
		dao.add(use);
	}

	@Override
	public void update(user use) {
		// TODO Auto-generated method stub
		dao.update(use);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public user findbyid(String id) {
		// TODO Auto-generated method stub
		return dao.findbyid(id);
	}

	@Override
	public List<user> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public user login(String username,String password) {
		// TODO Auto-generated method stub
		user use = dao.findbyname(username);
		if (use!=null) {
			if (password.equals(use.getPassword())) {
		
				return use;
			}
		}
		return null;
		
	}

	@Override
	public user findbyname(String username) {
		// TODO Auto-generated method stub
		return dao.findbyname(username);
	}

}
