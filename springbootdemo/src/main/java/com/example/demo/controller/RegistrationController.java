package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

@Controller
public class RegistrationController {


	@RequestMapping("/registration")
	public String registratuinlink()
	{
		
		return "registration";
		
	}

	
	@RequestMapping("/register")
	public String registrer()
	{
		
		
		
		return "registration";
		
	}
}
