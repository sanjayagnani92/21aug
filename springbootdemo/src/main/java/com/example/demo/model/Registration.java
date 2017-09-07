package com.example.demo.model;

public class Registration {

	private String username;
	private String password;
	private String phone;
	private String firstname;
	private String lastname;
	private int roleid;
	private String address;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Registration(String username, String password, String phone, String firstname, String lastname, int roleid,
			String address, String email) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roleid = roleid;
		this.address = address;
		this.email = email;
	}
	
	
	
	
	
}
