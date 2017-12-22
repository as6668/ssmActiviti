package com.service;

import java.util.Map;

import com.entity.user;

public interface IActivitiService {
	//启动流程
		public void qd (Map<String, Object> map,String key);
		//查看流程代办
		public Map<String, Object> ckdb (String dbr);
		//设置流程代办
		public void szdb (Map<String, Object> map,String dbr);
		//流程提交
		public void tj (String taskid);

}
