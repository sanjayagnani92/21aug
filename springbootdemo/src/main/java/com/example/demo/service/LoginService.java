package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.*;
@Service
public class LoginService {

	
	@Autowired
	private Logindao logindao;

	public int verifypassword(String username, String password) {
	
		return logindao.verifypassword(username, password);
		
	}

	
	
 
	
}
