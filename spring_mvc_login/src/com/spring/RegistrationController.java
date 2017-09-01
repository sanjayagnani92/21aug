package com.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

@Controller

@SessionAttributes(names={"username"})
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
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("Registration");
		mav.addObject("user", new User());

		model.addAttribute("message", "Registration  Page ");

		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerprocess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		

	
		int uniqueID = UUID.randomUUID().hashCode();

		String query = " INSERT INTO user (id,username,firstname,lastname,email,address,password,phone,roleid) "
				+ "VALUES(" + uniqueID + ",'" + user.getUsername() + "','" + user.getFirstname() + "','"
				+ user.getLastname() + "', '" + user.getEmail() + "','" + user.getAddress() + "','" + user.getPassword()
				+ "'," + user.getPhone() + "," + 2 + ")";

		String query1 = "Insert into students(id,username)VALUES(" + uniqueID + ",'" + user.getUsername() + "')";
		session.execute(query);
		session.execute(query1);

		System.out.println("Data Inserted Successfully");

		return new ModelAndView("Registration", "firstname", user.getFirstname() + "Registered Successfully");
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginprocess(HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("login") Login login) {

		
		
		
		
		String s = "sanjay";
		int id = 100;
		String query = "select password, roleid from user where username ='" + login.getUsername() + "' ALLOW FILTERING; ";
		ResultSet result = session.execute(query);
		
		
		for (Row row : result) {
			String passwordd = row.getString("password");
			int roleid = row.getInt("roleid");
			id = roleid;
			System.out.println("Fetched Rowset results"+row);
			s = passwordd;
		}

		

		HttpSession sessionn=request.getSession();  
     sessionn.setAttribute("id",id);  
		if (s.compareTo(login.getPassword()) == 0 && id == 2) {
			model.addAttribute("message", login.getUsername() + " Student Logged in Successfully");
			String querystddetails = "select username,sub_maths,sub_ss,sub_maths_marks,sub_ss_marks from students where username ='" + login.getUsername()
					+ "' ALLOW FILTERING; ";
			//String querystddetails = "Select * from students";
			session.execute(querystddetails);
			ResultSet querystudentresult = session.execute(querystddetails);
			List<Student> list1 = new ArrayList<Student>();
			
 
			for(Row row: querystudentresult)
			{
				
				String username=row.getString("username");
				String sub_maths=row.getString("sub_maths");
				
			int sub_maths_marks=row.getInt("sub_maths_marks");

			String sub_ss=row.getString("sub_ss");

			int sub_ss_marks=row.getInt("sub_ss_marks");
			list1.add(new Student(sub_maths,sub_maths_marks,sub_ss,sub_ss_marks,username));
		
			

			}

			
//			List<User> list = new ArrayList<User>();
//			list.add(new User("s", "rahul", "S.Engineer"));
//			list.add(new User("sd", "aditya", "IT Manager"));
//			list.add(new User("ssa", "sachin", "Care Taker"));
//
		return new ModelAndView("s", "list1", list1);

			// return "s";

		}

		// && id ==1
		else if (s.compareTo(login.getPassword()) == 0 && id == 1) {
			
			if(id==2)
				
			{
				String list = "Not Authorised";
				return new ModelAndView("login", "list", list);
			}
			model.addAttribute("message", login.getUsername() + " Teacher Logged in Successfully");

			String querystddetails = "Select * from students";
			session.execute(querystddetails);
			ResultSet querystudentresult = session.execute(querystddetails);
			List<Student> list1 = new ArrayList<Student>();
			
 
			for(Row row: querystudentresult)
			{
				
				String username=row.getString("username");
				String sub_maths=row.getString("sub_maths");
				
			int sub_maths_marks=row.getInt("sub_maths_marks");

			String sub_ss=row.getString("sub_ss");

			int sub_ss_marks=row.getInt("sub_ss_marks");
			list1.add(new Student(sub_maths,sub_maths_marks,sub_ss,sub_ss_marks,username));
		
			

			}

	
			return new ModelAndView("studentsdata", "list1", list1);

		}

		
		else 
		{
			model.addAttribute("message", "Please check entered username and password");

			String list = "";
			return new ModelAndView("login", "list", list);

		}

	}
		
		@RequestMapping(value="/editstudent/{username}")  
	    public ModelAndView edit(@PathVariable String username){  
	       

			System.out.println(username);
			String message ="Successfully Updated";
			return new ModelAndView("updated","message",message);  
	}
		
		@RequestMapping(value="/deletestudent/{username}")  
	    public ModelAndView deleteStudent(@PathVariable String username){  
	       
			
			System.out.println(username);
			
			
			String deletequery ="delete from students where username = '"+username+"' ";
			session.execute(deletequery);
			String message ="Successfully Deleted";
			return new ModelAndView("updated","message",message);  
	}



		}
	
	
