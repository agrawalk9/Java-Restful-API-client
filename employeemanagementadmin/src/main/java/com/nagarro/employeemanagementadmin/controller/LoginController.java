package com.nagarro.employeemanagementadmin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.employeemanagementadmin.adminfacade.FacadeImpl;
import com.nagarro.employeemanagementadmin.pojo.UserPojo;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("------------------------------");
		ModelAndView mav=new ModelAndView(); 
		mav.setViewName("login");
		return mav;
	}

	@Autowired
	private FacadeImpl facade;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Hello");
		HttpSession session = request.getSession();
		session.setAttribute("facade", facade);
		if (facade.authenticateServiceFacadeMethod(username, password)) {
			UserPojo userPojo = new UserPojo();
			userPojo.setUsername(username);
			userPojo.setPassword(password);
			session.setAttribute("username", userPojo.getUsername());
			mav.setViewName("redirect:/home");
		} else {
			mav.setViewName("login");
		}
		return mav;
	}
}
