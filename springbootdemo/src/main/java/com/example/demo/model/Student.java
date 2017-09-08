package com.example.demo.model;

public class Student {

	private String lastname;
	private int age;
	private String firstname;
	private String username;
	private String sub_maths;
	private int sub_maths_marks;
	private String sub_ss;
	private int sub_ss_marks;
	
	
	public Student(String sub_maths, int sub_maths_marks, String sub_ss, int sub_ss_marks, String username) {
		super();
		this.sub_maths = sub_maths;
		this.sub_maths_marks = sub_maths_marks;
		this.sub_ss = sub_ss;
		this.sub_ss_marks = sub_ss_marks;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSub_maths() {
		return sub_maths;
	}

	public void setSub_maths(String sub_maths) {
		this.sub_maths = sub_maths;
	}

	public int getSub_maths_marks() {
		return sub_maths_marks;
	}

	public void setSub_maths_marks(int sub_maths_marks) {
		this.sub_maths_marks = sub_maths_marks;
	}

	public String getSub_ss() {
		return sub_ss;
	}

	public void setSub_ss(String sub_ss) {
		this.sub_ss = sub_ss;
	}

	public int getSub_ss_marks() {
		return sub_ss_marks;
	}

	public void setSub_ss_marks(int sub_ss_marks) {
		this.sub_ss_marks = sub_ss_marks;
	}

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
