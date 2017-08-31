package com.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.Bytes;

@Controller
public class RegistrationController {

	
	Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build(); 
	Session session = cluster.connect("smsdb");
	
	@RequestMapping("/")
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("message", "Welcome to home Page :from Controller");
		System.out.println("" + request.getSession().getCreationTime());
		System.out.println("Session" + request.getSession());

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());

		model.addAttribute("message", "Login Page ");

		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
		public ModelAndView showhome() {

			return new ModelAndView("home");

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showregister(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mav = new ModelAndView("Registration");
		mav.addObject("user", new User());
		
		
		

		model.addAttribute("message", "Registration  Page ");

		
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerprocess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		
         int uniqueID = UUID.randomUUID().hashCode();

		
		
		
		
		String query =" INSERT INTO user (id,username,firstname,lastname,email,address,password,phone) "
				+ "VALUES("+uniqueID+",'"+user.getUsername()+"','"+user.getFirstname()+"','"+user.getLastname()+"', '"+user.getEmail()+"','"+user.getAddress()+"','"+user.getPassword()+"',"+user.getPhone()+")";
		
		
		session.execute(query);
		
		System.out.println("Data Inserted Successfully");

		
		
		
		
		return new ModelAndView("Registration", "firstname", user.getFirstname() + "Registered Successfully");
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginprocess(HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("login") Login login) {

		System.out.println("Username:" + login.getUsername());
		String s = "sanjay";
		int id =100;
	
		System.out.println(s.compareTo(login.getUsername()));

		
		String query = "select * from user where username ='"+login.getUsername()+"' ALLOW FILTERING; ";
		session.execute(query);
		ResultSet result = session.execute(query);
		
	
		System.out.println(result);

		System.out.println("Columns Datatypes of table"+result.getColumnDefinitions());
		
		for (Row row : result) {
					System.out.println("Password is "+row.getString("password"));
						String passwordd =row.getString("password");
						
						
						
						String passworddss =row.getString("roleid");
						System.out.println("Passwords Dataype1:"+passworddss);
					//	String idd =row.getString("roleid");
						//id =idd;
						
						int i = Integer.parseInt(row.getString("roleidd"));

						System.out.println("Passwords Dataype2:"+i);
						
						id =i;
						
					System.out.println(row);;
		s= passwordd;
		}
		
		if (s.compareTo(login.getPassword()) == 0  && id ==2) {
				model.addAttribute("message", login.getUsername() + " Student Logged in Successfully");
			List<User> list=new ArrayList<User>();  
	        list.add(new User("s","rahul","S.Engineer"));  
	        list.add(new User("sd","aditya","IT Manager"));  
	        list.add(new User("ssa","sachin","Care Taker"));  
	          
	        return new ModelAndView("s","list",list);  
			
			
			//return "s";

		}
		
		
		else if (s.compareTo(login.getPassword()) == 0 && id ==1) {
				model.addAttribute("message", login.getUsername() + " Teacher Logged in Successfully");
			List<User> list=new ArrayList<User>();  
	        list.add(new User("s","rahul","S.Engineer"));  
	        list.add(new User("sd","aditya","IT Manager"));  
	        list.add(new User("ssa","sachin","Care Taker"));  
	          
	        return new ModelAndView("s","list",list);  
			
			
			//return "s";

		}

		else {
			model.addAttribute("message", "Please check entered username and password");

			System.out.println(response.getStatus());
			//return "login";
			String list ="s";
			  return new ModelAndView("login","list",list);  
				
		}

	}

}
