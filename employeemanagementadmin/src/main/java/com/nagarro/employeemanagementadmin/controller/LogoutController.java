package com.nagarro.employeemanagementadmin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public ModelAndView displayControllerMethod(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		session=null;
		mav.setViewName("login");
		return mav;
	}
}
