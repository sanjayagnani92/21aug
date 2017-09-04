package com.spring;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Dbconnection {
	Session session;
	
	public void dbconnect(){
		
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		 session= cluster.connect("smsdb");
	
	}
	
	public void dbconnectionexecute(String query){
	      session.execute(query);

	}
	
}
