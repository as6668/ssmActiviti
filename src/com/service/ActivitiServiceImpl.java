package com.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ActivitiServiceImpl implements IActivitiService{

	@Override
	public void qd(Map<String, Object> map, String key) {
		// TODO Auto-generated method stub
		ProcessEngine pe = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine();
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey(key, map);
		System.out.println(pi.getId());
		System.out.println(pi.getActivityId());
	}

	@Override
	public Map<String, Object> ckdb(String dbr) {
		// TODO Auto-generated method stub
		ProcessEngine pe = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine();
		TaskService taskService = pe.getTaskService();
		Task task = taskService.createTaskQuery().taskAssignee(dbr).singleResult();
		System.out.println(task.getId());
		System.out.println(task.getName());
		// 判断流程过程中的map
		Map<String, Object> vari = taskService.getVariables(task.getId());
			return vari;



	}

	@Override
	public void szdb(Map<String, Object> map, String dbr) {
		// TODO Auto-generated method stub
		ProcessEngine pe = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine();
		TaskService taskService = pe.getTaskService();
		Task task = taskService.createTaskQuery().taskAssignee(dbr).singleResult();
		if (map != null) {
			if (map.size() != 0) {
				taskService.setVariables(task.getId(), map);
				pe.getTaskService().complete(task.getId());
				System.out.println("提交完成");
			}
		}
	}
	@Override
	public void tj(String taskid) {
		// TODO Auto-generated method stub
		ProcessEngine pe = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine();
		pe.getTaskService().complete(taskid);
		System.out.println("提交完成");
	}
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ActivitiServiceImpl ser=	(ActivitiServiceImpl)ac.getBean("activitiServiceImpl");
		
		//流程启动
//        Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("u1", "张飞");
//		map.put("u2", "诸葛");
//		map.put("u3", "刘备");
//		ser.qd(map, "leave");
		//设置代办
		Map<String, Object> map = new HashMap<String, Object>();
//		//张飞
//		map.put("请假原因", "111111");
//		map.put("请假时间", 2);
//		map.put("请假开始时间", new Date());
//		ser.szdb(map, "张飞");
		//诸葛
//		map.put("审批1", "可以");
//		ser.szdb(map, "诸葛");
		//刘备
//		map.put("审批2", "可以");
//		ser.szdb(map, "刘备");
		
		
		//查看代办
		Map<String, Object> ckdb = ser.ckdb("刘备");
		Set<String> set=ckdb.keySet();
		for (String s : set) {	
		System.out.println("key>>"+s+" value>>"+ckdb.get(s));
		
		}

		//提交代办
		ser.tj("12502");
	}



}
