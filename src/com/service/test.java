package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.user;
import com.util.CommonUtil;



public class test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl bean = (UserServiceImpl) ac.getBean("userServiceImpl");


	user a=new user(null,"asa", "aaa", "acc", "没");
//		for (int i = 0; i < 10; i++) {
//			a.setId(a.getId()+"1");
//			bean.add(a);
//		}
//	bean.add(a);
//	bean.update(a);
//		List<user> findAll = bean.findAll();
//for (user user : findAll) {
//	System.out.println(user.getId());
//}
//	user login = bean.login("aaa", "acc");
//	if (login!=null) {
//		System.out.println("登陆成功");
//	}else {
//		System.out.println("登陆失败");
//	}
	CommonUtil.lcbs();
	}
}
