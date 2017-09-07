package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

@Controller

public class TeacherController {

	
	@RequestMapping("/teachersdetails")
	public String person(Model model)
	{
		
		Student s = new Student();
		s.setAge(12);
		s.setFirstname("Sanjay");
		s.setLastname("Agnani");
		model.addAttribute("student",s);
		return "teachersdetails";
		
	}
}
