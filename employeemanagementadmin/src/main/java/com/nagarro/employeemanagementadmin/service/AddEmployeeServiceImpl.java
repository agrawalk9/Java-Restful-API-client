package com.nagarro.employeemanagementadmin.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagementadmin.pojo.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AddEmployeeServiceImpl {

	@Autowired
	private EurekaClient client;
	@Inject 
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "unknown")
	public String addEmployeeMethod(Employee employee) {
		String uri="http://employeemanagement/api";
		System.out.println("uri= " + uri);
	    //RestTemplate restTemplate = new RestTemplate();
	    System.out.println("employee DOB: "+employee.getEmployeeDOB());
	    String result = restTemplate.postForObject( uri, employee, String.class);
	    return result;
	}

	public String unknown(Employee employee) {
		return "unknown";
	}
}
