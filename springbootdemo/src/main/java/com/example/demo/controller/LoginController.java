package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.Row;
import com.example.demo.model.Login;
import com.example.demo.model.Student;
import com.example.demo.service.LoginService;;



@Controller
@SessionAttributes("thought")
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
	public String login(Login login,Model model,HttpSession session)
	{ 
		
		System.out.println(session.getId());
	
		session.setAttribute("mysession",login.getUsername());
		System.out.println("Role id"+loginservice.verifypassword(login.getUsername(), login.getPassword()));
		int id = loginservice.verifypassword(login.getUsername(), login.getPassword());
		ModelAndView mav = new ModelAndView();
		session.setAttribute("mysessionid", id);
		String s ="ajay";
		mav.addObject("thought", s);
		System.out.println(session.getAttribute("mysessionid").getClass());
		System.out.println((Integer)session.getAttribute("mysessionid") == 2);
		if(id>0)
		{
			
			if(id == 2)
			{
				if((Integer)session.getAttribute("mysessionid")==2)// To check the authorization Role based 
				{
				
				System.out.println("ID stored in session:"+session.getAttribute("mysessionid"));
				System.out.println(session.getId());
				System.out.println(loginservice.getDetails(login.getUsername()));
				model.addAttribute("messages", loginservice.getDetails(login.getUsername()));
				model.addAttribute("sanjay","sanjayagnani");
				session.getAttribute("mysession");
				return "studentdetails";
				}
			}
			else
			{

				if((Integer)session.getAttribute("mysessionid")==1)// To check the authorization Role based 
					
				{
				System.out.println("ID stored in session:"+session.getAttribute("mysessionid"));
				System.out.println(session.getId());
				System.out.println(loginservice.getTeacherdetails());
				model.addAttribute("messages", loginservice.getTeacherdetails());
				model.addAttribute("sanjay","sanjayagnani");
				
				return "teachersdetails";
				}
			}
			
		}
		else 
		{
		return "error";
		}
		
		return "error";
	}
	
	
	// Mapping and returning About us Page	
			@RequestMapping(value ="/logout" )
			public String logout(HttpServletRequest request)
			{
				
				
				HttpSession session= request.getSession(false);
				 session.invalidate();
			        
	         return "login";
				
	
				
			}

	
}
