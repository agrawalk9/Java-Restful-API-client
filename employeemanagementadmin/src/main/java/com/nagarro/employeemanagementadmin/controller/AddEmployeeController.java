package com.nagarro.employeemanagementadmin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.employeemanagementadmin.adminfacade.FacadeImpl;
import com.nagarro.employeemanagementadmin.pojo.Employee;

@Controller
public class AddEmployeeController {
	
	@RequestMapping("/addEmployee")
	public ModelAndView init() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("add-employee");
		return mav;
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) {
		Employee employee = new Employee();
		employee.setEmployeeCode(Long.parseLong(request.getParameter("employeeCode")));
		employee.setEmployeeDOB(request.getParameter("employeeDOB"));
		employee.setEmployeeEmail(request.getParameter("employeeEmail"));
		employee.setEmployeeLoc(request.getParameter("employeeLoc"));
		employee.setEmployeeName(request.getParameter("employeeName"));
		FacadeImpl facade = (FacadeImpl) request.getSession().getAttribute("facade");
		ModelAndView mav = new ModelAndView();
		String result = facade.addEmployeeServiceFacadeMethod(employee);
		System.out.println("result:"+result);
		mav.setViewName("redirect:/home");
		return mav;
	}
}
