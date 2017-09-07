package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

@Repository
public class Logindao {

	Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	Session session = cluster.connect("smsdb");

	// Verify Username and Password and retun roleid ("If roleid -1 login error:
	// No data found ")
	public int verifypassword(String username, String password) {
		System.out.println(username+""+password);
		String query = "select password, roleid from user where username ='" + username + "' ALLOW FILTERING; ";
		System.out.println("Query log:"+query);
		ResultSet result = session.execute(query);

		for (Row row : result) {
			String rpassword = row.getString("password");
			if (rpassword.compareTo(password) == 0 ) {

				int roleid = row.getInt("roleid");

				System.out.println("Fetched Rowset results" + row);

				return roleid;

			}

			else {
				System.out.println("No records found");
				return -1;

			}
		}

		return -1;
	}
	
	
	


}
