package com.nagarro.employeemanagementadmin.adminfacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.employeemanagementadmin.pojo.Employee;
import com.nagarro.employeemanagementadmin.service.AddEmployeeServiceImpl;
import com.nagarro.employeemanagementadmin.service.AuthenticateServiceImpl;
import com.nagarro.employeemanagementadmin.service.GetAllEmployeesServiceImpl;
import com.nagarro.employeemanagementadmin.service.UpdateEmployeeServiceImpl;

@Service
public class FacadeImpl {
	
	@Autowired
	private AuthenticateServiceImpl authenticateService;
	@Autowired
	private GetAllEmployeesServiceImpl get;
	@Autowired
	private AddEmployeeServiceImpl add;
	@Autowired
	private UpdateEmployeeServiceImpl update;
	
	public boolean authenticateServiceFacadeMethod(String username,String password) {
		if(authenticateService.authenticate(username,password)) {
			return true;
		}
		return false;
	}

	public List<Employee> displayServiceFacadeMethod() {
		System.out.println("1--------");
		return get.getEmployeesMethod();
	}

	public String addEmployeeServiceFacadeMethod(Employee employee) {
		return add.addEmployeeMethod(employee);
	}

	public void updateEmployeeServiceFacadeMethod(Employee employee) {
		update.updateEmployeeMethod(employee);
	}

}
