package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.example.demo.model.Student;

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
	
	
	//Get Details of user
	
	public List<Student> getDetails(String username)
	{
		String query = "select * from students where username ='" + username + "' ALLOW FILTERING; ";
		
		System.out.println("Query log:"+query);
		ResultSet result = session.execute(query);
		List<Student> list1 = new ArrayList<Student>();
		
		 
		for(Row row: result)
		{
			
			String usernamee=row.getString("username");
			String sub_maths=row.getString("sub_maths");
			
		   int sub_maths_marks=row.getInt("sub_maths_marks");

		   String sub_ss=row.getString("sub_ss");

		int sub_ss_marks=row.getInt("sub_ss_marks");
		list1.add(new Student(sub_maths,sub_maths_marks,sub_ss,sub_ss_marks,usernamee));
		}
		return list1;
	}
	
	public List<Student> getTeacherdetails()
	{
		
		String query ="Select * from students";
		System.out.println("Query log:"+query);
		ResultSet result = session.execute(query);
		List<Student> list1 = new ArrayList<Student>();
		
		 
		for(Row row: result)
		{
			
			String usernamee=row.getString("username");
			String sub_maths=row.getString("sub_maths");
			
		   int sub_maths_marks=row.getInt("sub_maths_marks");

		   String sub_ss=row.getString("sub_ss");

		int sub_ss_marks=row.getInt("sub_ss_marks");
		list1.add(new Student(sub_maths,sub_maths_marks,sub_ss,sub_ss_marks,usernamee));
		}
		return list1;
	}


	


}
