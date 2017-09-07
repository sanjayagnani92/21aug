package com.hello.Test.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hello.Test.Entity.Student;
@Repository
public class StudentDao {

	
	private static Map<Integer,Student> students;
	
	
	static{
		
		students = new HashMap<Integer, Student>()
				{
			
			
			
			{
				
				put(1, new Student(1,"Sanjay","CS"));
				put(2, new Student(2,"Sanjay2","SS"));
				put(3, new Student(3,"Sanjay3","Maths"));
				put(4, new Student(4,"Sanjay4","Db"));

			}
			
				};
		
	}
	
	
public Collection<Student> getAllStudents(){
	
	return this.students.values();
	
	
}

 
public  Student getStudentById(int id )
{
	return this.students.get(id);
}
	
	
public  void deleteStudentById(int id )
{
	 this.students.remove(id);
}


public void updateStudent(Student student){
	
Student s = students.get(student.getId());
s.setCourse(student.getCourse());
s.setName(student.getName());
students.put(student.getId(), student);

}

public  void insertStudent(Student student) {
	this.students.put(student.getId(),student);

}


}
