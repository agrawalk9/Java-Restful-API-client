package com.nagarro.employeemanagementadmin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.employeemanagementadmin.adminfacade.FacadeImpl;
import com.nagarro.employeemanagementadmin.pojo.Employee;

@Controller
public class HomeController {

	@RequestMapping(value="/home")
	public ModelAndView displayControllerMethod(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		FacadeImpl facade = (FacadeImpl) request.getSession().getAttribute("facade");

		List<Employee> employeeList = facade.displayServiceFacadeMethod();
		for (Employee e : employeeList) {
			System.out.println("employeeName: " + e.getEmployeeName());
		}

		mav.setViewName("welcome");
		mav.addObject("employeeList", employeeList);
		return mav;
	}
}
