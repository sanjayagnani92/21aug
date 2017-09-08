package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication

@Controller
@ComponentScan({"com.example.demo","com.example.demo.controller"})
public class SpringbootdemoApplication {

	//@ResponseBody
	//Uncomment to just return string as Response Body
	@RequestMapping("/")
	String entry()
	{	
		return "home";
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
