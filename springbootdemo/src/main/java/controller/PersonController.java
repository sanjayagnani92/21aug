package controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Student;

@Controller
@ComponentScan
public class PersonController {
	
@RequestMapping("/students")
	public String person(Model model)
	{
		
		Student s = new Student();
		s.setAge(12);
		s.setFirstname("Sanjay");
		s.setLastname("Agnani");
		model.addAttribute("student",s);
		return "Sanjay";
		
	}
	

}
