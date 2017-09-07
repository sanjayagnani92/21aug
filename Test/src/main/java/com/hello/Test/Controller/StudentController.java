package com.hello.Test.Controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hello.Test.Entity.Student;
import com.hello.Test.Service.StudentService;


@RestController

@RequestMapping("/students")
public class StudentController {

	
	@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
	
@Autowired
private StudentService studentService;

@RequestMapping(method = RequestMethod.GET)
public Collection<Student> getAllStudents(){
		
		return studentService.getAllStudents();
		  
	}

@RequestMapping(value ="/{id}", method = RequestMethod.GET)

public  Student getStudentById(@PathVariable("id") int id )
{
	return studentService.getStudentById(id);
}

@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
public  void  deleteStudentById(@PathVariable("id") int id )
{
	 studentService.deleteStudentById(id);
}


@RequestMapping(method = RequestMethod.PUT,consumes = MediaType .APPLICATION_JSON_VALUE)

public void updateStudentById(
		@RequestBody Student student){
	studentService.updateStudent(student);
	
	
	
	
}


@RequestMapping(method = RequestMethod.POST,consumes = MediaType .APPLICATION_JSON_VALUE )

public void insertstudent(@RequestBody Student student){
	studentService.insertStudent(student);


}
}
