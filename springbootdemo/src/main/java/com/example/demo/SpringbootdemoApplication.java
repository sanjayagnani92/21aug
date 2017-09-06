package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication

@Controller
@ComponentScan({"demo","controller"})
public class SpringbootdemoApplication {

	@ResponseBody
	@RequestMapping("/")
	String entry()
	{
		return "My String boot app";
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
