package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.Row;
import com.example.demo.dao.*;
import com.example.demo.model.Student;
@Service
public class LoginService {

	
	@Autowired
	private Logindao logindao;

	public int verifypassword(String username, String password) {
	
		return logindao.verifypassword(username, password);
		
	}

	public List<Student> getDetails(String username)
	{
		
		
		return logindao.getDetails(username);
		
	}	
 
	
	
	public List<Student> getTeacherdetails()
	{
		return logindao.getTeacherdetails();
		
		
	}
}
