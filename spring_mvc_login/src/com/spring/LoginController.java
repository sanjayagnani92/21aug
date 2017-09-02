package com.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@SessionAttributes("id")
public class LoginController {

	private static Logger logger = LogManager.getLogger(LoginController.class.getName());

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mav = new ModelAndView("login");
		
	
		mav.addObject("login", new Login());

		model.addAttribute("message", "Login Page ");
		
		logger.info("Login Method");

		return mav;
	}

	
	
	

}
