package com.hello.Test.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.Test.Dao.*;


import com.hello.Test.Entity.Student;

@Service
public class StudentService { 

	@Autowired
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		
		return studentDao.getAllStudents();
		
	}
	
	public  Student getStudentById(int id )
	{
		return studentDao.getStudentById(id);
	}
	
	
	public  void  deleteStudentById(int id )
	{
		 studentDao.deleteStudentById(id);
	}
	
	
	public void updateStudent(Student student){
		
		this.studentDao.updateStudent(student);
		}

public void insertStudent(Student student){
		
		this.studentDao.insertStudent(student);
		}
}




