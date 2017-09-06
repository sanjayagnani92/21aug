package model;

public class Student {

	String lastname;
	int age;
	String firstname;
	
	
	public Student() {
		super();
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public Student(String firstname, String lastname, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
