package com.nagarro.employeemanagementadmin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagementadmin.pojo.Employee;

@Service
public class AddEmployeeServiceImpl {

	public String addEmployeeMethod(Employee employee) {
		final String uri = "http://localhost:8085/api";
	    RestTemplate restTemplate = new RestTemplate();
	    System.out.println("employee DOB: "+employee.getEmployeeDOB());
	    String result = restTemplate.postForObject( uri, employee, String.class);
	    return result;
	}

}
