package com.nagarro.employeemanagementadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.employeemanagementadmin.repository.UserRepository;


@Service
public class AuthenticateServiceImpl {

	@Autowired
	private UserRepository repository;
	
	public boolean authenticate(String username, String password) {
		//User u=repository.findOne();
		return true;
	}

	
}
