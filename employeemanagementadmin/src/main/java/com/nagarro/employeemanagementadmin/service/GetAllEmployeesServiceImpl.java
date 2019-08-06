package com.nagarro.employeemanagementadmin.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
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
public class GetAllEmployeesServiceImpl {

	@Autowired
	private EurekaClient client;
	@Inject 
	private RestTemplate restTemplate;
	 
	public List<Employee> getEmployeesMethod() {
		String uri="http://employeemanagement/api";
		System.out.println("uri= " + uri);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Employee employee = new Employee();
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		ResponseEntity<List<Employee>> result = restTemplate.exchange(uri, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		return result.getBody();
	}

}
