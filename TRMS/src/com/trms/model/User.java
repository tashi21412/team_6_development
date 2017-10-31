package com.trms.model;

//import java.sql.Date;

public class User {

	private String username = "";
	
	private String password = "";
	
	private String firstName = "";
	
	private String lastName = "";
	
	private String role = "";
	
//	private Date hiredDate;
	
	private double availableReimbursement = 0;	

	public User() {
		super();
	}

	public User(String username, String password, String firstName, String lastName, String role,
			double availableReimbursement) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.availableReimbursement = availableReimbursement;
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

//	public Date getHiredDate() {
//		return hiredDate;
//	}
//
//	public void setHiredDate(Date hiredDate) {
//		this.hiredDate = hiredDate;
//	}
	
	public double getAvailableReimbursement() {
		return availableReimbursement;
	}

	public void setAvailableReimbursement(double availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", role=" + role + ", availableReimbursement=" + availableReimbursement + "]";
	}

//	@Override
//	public String toString() {
//		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", role=" + role + ", hiredDate=" + hiredDate + ", availableReimbursement="
//				+ availableReimbursement + "]";
//	}
		
}