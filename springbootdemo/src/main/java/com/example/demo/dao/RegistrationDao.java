package com.example.demo.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class RegistrationDao {


	Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	Session session = cluster.connect("smsdb");
	
	public int Registration()
	{
	

//		String query = " INSERT INTO user (id,username,firstname,lastname,email,address,password,phone,roleid) "
//				+ "VALUES(" + uniqueID + ",'" + user.getUsername() + "','" + user.getFirstname() + "','"
//				+ user.getLastname() + "', '" + user.getEmail() + "','" + user.getAddress() + "','" + user.getPassword()
//				+ "'," + user.getPhone() + "," + 2 + ")";
//
//		String query1 = "Insert into students(id,username)VALUES(" + uniqueID + ",'" + user.getUsername() + "')";
//		session.execute(query);
//		session.execute(query1);
//
		
		
		return -1;
	}
	
}
