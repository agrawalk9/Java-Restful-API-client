package com.nagarro.employeemanagementadmin.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagementadmin.pojo.Employee;

@Service
public class GetAllEmployeesServiceImpl {

	public List<Employee> getEmployeesMethod() {
		final String uri = "http://localhost:8085/api";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    Employee employee = new Employee();
	    HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
	    ResponseEntity<List<Employee>> result = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>() {});
	    return result.getBody();
	}

}