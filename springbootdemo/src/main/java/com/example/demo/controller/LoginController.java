package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;;


@Controller

public class LoginController {
	//Maintaining Login and Logout Activities and Static Routes
	
	@Autowired
	private LoginService loginservice;
	@RequestMapping("/teacherlogin")
	public String teacherlogin()
	{
		return "login";
		
	}
	
	
	//returning Login Page	
	@RequestMapping("/studentlogin")
	public String studentlogin()
	{
		return "login";
		
	}
	

	   // Mapping and returning About us Page	
		@RequestMapping("/about")
		public String about()
		{
			return "about";
			
		}


	
	//returning to  Page as per user role	
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public String login(Login login)
	{ 
		System.out.println("Role id"+loginservice.verifypassword(login.getUsername(), login.getPassword()));
		int id = loginservice.verifypassword(login.getUsername(), login.getPassword());
		
		if(id>0)
		{
			
			if(id == 2)
			{
				
				
				return "studentdetails";
			}
			else
			{
				return "teachersdetails";
			}
			
		}
		else 
		{
		return "error";
		}
		
		
	}
	
	
	// Mapping and returning About us Page	
			@RequestMapping(value ="/logout" )
			public String logout(HttpServletRequest request)
			{
				 HttpSession session= request.getSession(false);
			        if(session != null) {
			            session.invalidate();
			        }
	         return "login";
				
	
				
			}

	
}
