package com.spring;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

@SessionAttributes("id")
@Controller
public class RegistrationController {
	
	
	//private static Logger logger = LogManager.getLogger(RegistrationController.class.getName());
	private static Logger logger = LogManager.getRootLogger();
	
	Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	Session session= cluster.connect("smsdb");
	
	int globalid =100;
	
	
	@RequestMapping("/")
	public String login(Model model, HttpServletRequest request) {
//PropertyConfigurator.configure("log4j.properties");

		
		
		logger.info("Route Controller Main Page");

		logger.trace("This is a Trace");
        logger.debug("This is a Debug");
        logger.info("This is an Info");
        logger.warn("This is a Warn");
        logger.error("This is an Error");
        logger.fatal("This is a Fatal");
        
        
		model.addAttribute("message", "Welcome to home Page :from Controller");
		
		System.out.println("Epoch Time:" + request.getSession().getCreationTime());
		long seconds =request.getSession().getCreationTime();
		LocalDateTime dateTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.UTC);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
		String formattedDate = dateTime.format(formatter);
		
//		try {
//			System.out.println("Hostname"+InetAddress.getLocalHost().getHostName());
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		System.out.println("Time of request"+formattedDate);
		
		logger.info("Session" + request.getSession());
		logger.info("Session iD "+request.getRequestedSessionId());
		logger.info("Remote Ip Address:"+request.getRemoteAddr()+"Remote User:"+request.getRemoteUser());
		logger.info("Server name and port"+request.getServerName()+" Port:"+request.getServerPort());

		logger.info("Cookies:"+request.getCookies());
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showhome() {

		return new ModelAndView("home");

	}
	
	
	 @RequestMapping(value="/logout",method = RequestMethod.GET)
     public String logout(HttpServletRequest request){
         HttpSession httpSession = request.getSession();
         httpSession.invalidate();
         logger.info("logout Method");
         return "home";
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

		String query = " INSERT INTO user (id,username,firstname,lastname,email,address,password,phone,roleid) "
				+ "VALUES(" + uniqueID + ",'" + user.getUsername() + "','" + user.getFirstname() + "','"
				+ user.getLastname() + "', '" + user.getEmail() + "','" + user.getAddress() + "','" + user.getPassword()
				+ "'," + user.getPhone() + "," + 2 + ")";

		logger.fatal(query);
		String query1 = "Insert into students(id,username)VALUES(" + uniqueID + ",'" + user.getUsername() + "')";
		session.execute(query);
		session.execute(query1);

		System.out.println("Data Inserted Successfully");

		return new ModelAndView("Registration", "firstname", user.getFirstname() + "Registered Successfully");
	}

	
	
	 @RequestMapping(value="/404" )
	    public String error404(){
	       // DO stuff here 
	        return "NotFound";
	        
	 }
	 
	 @ExceptionHandler(NoHandlerFoundException.class)
     public String handle(Exception ex) {

        return "NotFound";//this is view name
    }
	 
			
		@RequestMapping(value="/editstudent/{username}")  
	    public ModelAndView edit(@PathVariable String username){  
	       
			if(globalid ==2)
			{
				String message ="Not Authorized to edit update student";
				return new ModelAndView("updated","message",message);  

				
			}
			
			
			String query = "select username,sub_maths,sub_ss,sub_maths_marks,sub_ss_marks from students where username ='" + username
			+ "' ALLOW FILTERING; ";
			logger.fatal(query);
	session.execute(query);
	ResultSet querystudentresult = session.execute(query);
	List<Student> list1 = new ArrayList<Student>();
	

	for(Row row: querystudentresult)
	{
		
		String sub_maths=row.getString("sub_maths");
		
	int sub_maths_marks=row.getInt("sub_maths_marks");

	String sub_ss=row.getString("sub_ss");

	int sub_ss_marks=row.getInt("sub_ss_marks");
	list1.add(new Student(sub_maths,sub_maths_marks,sub_ss,sub_ss_marks,username));

	

	}

	return new ModelAndView("studentsdataedit", "list1", list1);

			
//			System.out.println(username);
	//		String message ="Successfully Updated";
		//	return new ModelAndView("updated","message",message);  
	}
		
		@RequestMapping(value="/deletestudent/{username}")  
	    public ModelAndView deleteStudent(@PathVariable String username){  
	       
			
			if(globalid ==2)
			{
				String message ="Not Authorized to delete Student";
				return new ModelAndView("updated","message",message);  

				
			}
			
			System.out.println(username);
			
			
			String deletequery ="delete from students where username = '"+username+"' ";
			session.execute(deletequery);
			String message ="Successfully Deleted";
			return new ModelAndView("updated","message",message);  
	}

		
	
		}
	
	
