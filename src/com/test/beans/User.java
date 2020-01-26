package com.test.beans;

public class User {
	
	private String password;
	private String username;
	private String firstName;
	private String lastName;

	private String activity;
	public User(String username, String password, String firstName, String lastName, String activity) {
		this.username=username;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.activity=activity;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	

}
