package com.spring;

public class Student {

	
	Student(){
		
		
	}
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	private String sub_maths;
	private String sub_ss;
	
	private int sub_maths_marks;
	
	private int sub_ss_marks;

	public String getSub_maths() {
		return sub_maths;
	}

	public Student(String sub_maths, int sub_maths_marks, String sub_ss, int sub_ss_marks,String username) {
		super();
		this.sub_maths = sub_maths;
		this.sub_ss = sub_ss;
		this.sub_maths_marks = sub_maths_marks;
		this.sub_ss_marks = sub_ss_marks;
		this.username= username;
	}

	public void setSub_maths(String sub_maths) {
		this.sub_maths = sub_maths;
	}

	public String getSub_ss() {
		return sub_ss;
	}

	public void setSub_ss(String sub_ss) {
		this.sub_ss = sub_ss;
	}

	public int getSub_maths_marks() {
		return sub_maths_marks;
	}

	public void setSub_maths_marks(int sub_maths_marks) {
		this.sub_maths_marks = sub_maths_marks;
	}

	public int getSub_ss_marks() {
		return sub_ss_marks;
	}

	public void setSub_ss_marks(int sub_ss_marks) {
		this.sub_ss_marks = sub_ss_marks;
	}
	
}
