package com.spring;

import static org.junit.Assert.*;


import org.apache.log4j.Logger;
import org.junit.Test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class LoginTest {


	Login logintest = new Login();
	Logger log = Logger.getLogger(LoginTest.class);
	
	@Test
	public void test() {
		logintest.setUsername("sams");
		logintest.setPassword("samwillis");
		String passwordd = null;
		
		System.out.println("Started TestCase1");
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		Session session= cluster.connect("smsdb");

		
		String query = "select password, roleid from user where username ='" + logintest.getUsername() + "' ALLOW FILTERING; ";
		ResultSet rs = session.execute(query);
		System.out.println("Query Statement:"+query);
		
		if(rs == null)
		{
			
			assertEquals(logintest.getPassword(),passwordd);
		}
		
		for (Row row : rs) {
			 passwordd = row.getString("password");
			System.out.println(passwordd);
			
			}
		assertEquals(logintest.getPassword(), passwordd);
		
		
	}

	
	
}
