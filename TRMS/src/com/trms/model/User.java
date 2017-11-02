package com.trms.model;

import java.util.Date;

public class User {

	private long userID = 0;
	
	private String username = "";
	
	private String password = "";
	
	private String firstName = "";
	
	private String lastName = "";
	
	private String email = "";
	
	private Date hiredDate = null;
	
	private double availableReimbursement = 0.00;

	public User() {
		super();
	}

	public User(String username, String password, String firstName, String lastName, String email, Date hiredDate,
			double availableReimbursement) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hiredDate = hiredDate;
		this.availableReimbursement = availableReimbursement;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	public double getAvailableReimbursement() {
		return availableReimbursement;
	}

	public void setAvailableReimbursement(double availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", hiredDate=" + hiredDate
				+ ", availableReimbursement=" + availableReimbursement + "]";
	}
		
}