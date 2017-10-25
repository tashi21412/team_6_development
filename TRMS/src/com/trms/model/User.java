package com.trms.model;

import java.util.Calendar;

public class User {

	private String username = "";
	
	private String password = "";
	
	private String firstName = "";
	
	private String lastName = "";
	
	private String role = "";
	
	private Calendar hiredDate;
	
	private double availableReimburstment = 0;	

	public User() {
		super();
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Calendar getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Calendar hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	public double getavailableReimburstment() {
		return availableReimburstment;
	}

	public void setavailableReimburstment(double availableReimburstment) {
		this.availableReimburstment = availableReimburstment;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", role=" + role + ", hiredDate=" + hiredDate + ", availableReimburstment="
				+ availableReimburstment + "]";
	}
		
}