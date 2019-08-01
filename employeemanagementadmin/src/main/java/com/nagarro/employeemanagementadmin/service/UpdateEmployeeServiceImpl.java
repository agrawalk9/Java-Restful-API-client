package com.nagarro.employeemanagementadmin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagementadmin.pojo.Employee;

@Service
public class UpdateEmployeeServiceImpl {

	public void updateEmployeeMethod(Employee employee) {
		final String uri = "http://localhost:8085/api/profiles/update/{employeeCode}";
		RestTemplate restTemplate = new RestTemplate();
		 Map<String, Long> params = new HashMap<String, Long>();
		    params.put("employeeCode", employee.getEmployeeCode());

		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		ResponseEntity<Employee> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, Employee.class,params);
		Employee result = response.getBody();
		//return result;
	}
}
