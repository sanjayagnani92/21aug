package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

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
	

}
