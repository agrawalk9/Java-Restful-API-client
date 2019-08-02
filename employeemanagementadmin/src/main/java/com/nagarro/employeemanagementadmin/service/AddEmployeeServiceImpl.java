package com.nagarro.employeemanagementadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagementadmin.pojo.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class AddEmployeeServiceImpl {

	@Autowired
	private EurekaClient client;
	
	public String addEmployeeMethod(Employee employee) {
		InstanceInfo instanceInfo=client.getNextServerFromEureka("employeemanagement", false);
		String uri = instanceInfo.getHomePageUrl()+"api";
	    RestTemplate restTemplate = new RestTemplate();
	    System.out.println("employee DOB: "+employee.getEmployeeDOB());
	    String result = restTemplate.postForObject( uri, employee, String.class);
	    return result;
	}

}
