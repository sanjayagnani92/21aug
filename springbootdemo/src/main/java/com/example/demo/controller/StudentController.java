package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@Controller
@ComponentScan
public class StudentController {
	
HttpSession session;
	
	

	@RequestMapping(value = "/studentdetails")
	public String person(Model model)
	{
		
		Student s = new Student();
		s.setAge(12);
		s.setFirstname("Sanjay");
		s.setLastname("Agnani");
		model.addAttribute("student",s);
		return "NewFile";
		
	}
	
	@RequestMapping(value="/editstudent/{username}")
	public String editstudent(){
		
		if(session.getId()=="2"){
			
			System.out.println(session.getId());
		}
		return "teachersdetails";
	}
	
	@RequestMapping(value="/deletestudent/{username}")
	public String deletestudent(){
		return "teachersdetails";
	}

}
