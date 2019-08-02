package com.nagarro.employeemanagementadmin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagementadmin.pojo.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class UpdateEmployeeServiceImpl {

	@Autowired
	private EurekaClient client;
	
	public void updateEmployeeMethod(Employee employee) {
		InstanceInfo instanceInfo=client.getNextServerFromEureka("employeemanagement", false);
		String uri = instanceInfo.getHomePageUrl()+"api/profiles/update/{employeeCode}";
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
