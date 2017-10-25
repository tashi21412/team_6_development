package com.trms.model;

import java.util.Calendar;

public class Employee {
	
	private String username = "";
	
	private String directSupervisor = "";
	
	private String departmentHead = "";
	
	private long trFormID = 0;

	public Employee() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDirectSupervisor() {
		return directSupervisor;
	}

	public void setDirectSupervisor(String directSupervisor) {
		this.directSupervisor = directSupervisor;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public long getTrFormID() {
		return trFormID;
	}

	public void setTrFormID(long trFormID) {
		this.trFormID = trFormID;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", directSupervisor=" + directSupervisor + ", departmentHead="
				+ departmentHead + ", trFormID=" + trFormID + "]";
	}
	
}