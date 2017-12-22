package com.util;

import java.util.UUID;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;


public class CommonUtil {
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	
	
	static ProcessEngine pe = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
			.buildProcessEngine();
	//流程部署
	
	public static void lcbs(){
		
		Deployment deployment = pe.getRepositoryService().createDeployment()
				.addClasspathResource("activiti/leave.bpmn")
				.name("员工请假流程")
				.addClasspathResource("activiti/leave.png").deploy();

		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
		
		
	}
}
