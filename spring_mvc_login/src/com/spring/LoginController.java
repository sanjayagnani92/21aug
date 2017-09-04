package com.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


@Controller
@SessionAttributes("id")
public class LoginController {

	//private static Logger logger = Logger.getLogger(LoginController.class.getName());
	Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	Session session= cluster.connect("smsdb");
	private static Logger logger = LogManager.getRootLogger();
	
	int globalid =100;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mav = new ModelAndView("login");
		
	
		mav.addObject("login", new Login());

		model.addAttribute("message", "Login Page ");
		
		//logger.info("Login Method");

		return mav;
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
		globalid=id;
		
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


			logger.info(id);
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



	
	

}
