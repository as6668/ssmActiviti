package com.contorller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.avalon.framework.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.user;
import com.service.ActivitiServiceImpl;
import com.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/loginc")
public class loginAction {

	@Autowired
	private UserServiceImpl ser;
	@Autowired
	private ActivitiServiceImpl aser;

	// @RequestMapping(value = "/login")
	//
	// public String login(HttpServletRequest req,ModelAndView model) {
	// String username = req.getParameter("username");
	// String password = req.getParameter("password");
	// user login = ser.login(username, password);
	// if(login!=null){
	//
	//
	// req.setAttribute("user", login);
	// return "login";
	//
	// }
	// return "index";
	//
	// }
	@RequestMapping(value = "/login2")
	public ModelAndView login2(HttpServletRequest req, ModelAndView model) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user login = ser.login(username, password);
		if (login != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", login);
			model.setViewName("index");
			System.out.println(login.getNc());
			return model;
		} else {
			model.setViewName("login");
		}
		return model;
	}

	@RequestMapping(value = "/qd")
	public ModelAndView qd(HttpServletRequest req, ModelAndView model) {
		String s1 = req.getParameter("s1");
		String s2 = req.getParameter("s2");
		String s3 = req.getParameter("s3");
		HttpSession session = req.getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		user a = (user) session.getAttribute("user");
	
		user use2 = ser.findbyname(s2);
		user use3 = ser.findbyname(s3);
		map.put("u1", a.getNc());
		map.put("u2", use2.getNc());
		map.put("u3", use3.getNc());
		aser.qd(map, s1);
		//model.addObject("user",a);
	
		model.setViewName("lc1");
		return model;
	}
	@RequestMapping(value="tj1")
	public ModelAndView tj1(String qjr,String qjts,String qjyy,ModelAndView model,HttpServletRequest req){
		//设置参数并提交流程
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("请假人", qjr);
		map.put("请假天数", qjts);
		map.put("请假原因", qjyy);
		aser.szdb(map, qjr);;
		
		//跳转页面
		model.addObject("qjr",qjr);
		model.setViewName("lc2");	
		return model;
	}
	 //流程审批
		@RequestMapping(value="sp")
		public ModelAndView sp(ModelAndView model,HttpServletRequest req){		
			//当前操作人
			user u1=(user) req.getSession().getAttribute("user");
			//查看代办
			System.out.println(u1.getNc());
			
			Map map=aser.ckdb(u1.getNc());
			//将传页面
			model.addObject("c1", map);
			model.setViewName("lc3");	
			return model;
		}
		//tj2
		@RequestMapping(value="tj2")
		public ModelAndView tj2(String yj1,String yj2,ModelAndView model,HttpServletRequest req){			
			//当前操作人
			user u1=(user) req.getSession().getAttribute("user");
			//设置参数并提交流程
			Map<String,Object> map=new HashMap<String,Object>();
			if(!"".equals(yj1)&&yj1!=null){
			   map.put("直属部门领导", yj1);
			}
			if(!"".equals(yj2)&&yj2!=null){
			   map.put("终极boss领导", yj2);
			}
			aser.szdb(map, u1.getNc());
			//跳转页面
			model.addObject("qjr", u1.getNc());
			model.setViewName("lc4");
			return model;
		}
	
}
