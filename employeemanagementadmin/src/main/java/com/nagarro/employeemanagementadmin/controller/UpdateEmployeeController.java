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
public class UpdateEmployeeController {

	@RequestMapping("/updateEmployee")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update-employee");
		return mav;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hey There Kitty-----------");

		ModelAndView mav = new ModelAndView();
		Employee employee = new Employee();
		employee.setEmployeeCode(Long.parseLong(request.getParameter("employeeCode")));
		employee.setEmployeeDOB(request.getParameter("employeeDOB"));
		employee.setEmployeeEmail(request.getParameter("employeeEmail"));
		employee.setEmployeeLoc(request.getParameter("employeeLoc"));
		employee.setEmployeeName(request.getParameter("employeeName"));
		FacadeImpl facade = (FacadeImpl) request.getSession().getAttribute("facade");
		facade.updateEmployeeServiceFacadeMethod(employee);
		mav.setViewName("redirect:/home");
		return mav;

	}
}
