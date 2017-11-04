package com.trms.model;

import java.util.Date;

public class TuitionReimbursementForm {
	
	private long formID = 0;
	
	private Date eventDate = null;
	
	private String eventTime = null;
	
	private String location = "";
	
	private String description = "";
	
	private double cost = 0.00;
	
	private String gradingFormat = "";
	
	private String eventType = "";
	
	private String justification = "";
	
	private String username = "";

	public TuitionReimbursementForm() {
		super();
	}

	public TuitionReimbursementForm(Date eventDate, String eventTime, String location, String description, double cost,
			String gradingFormat, String eventType, String justification, String username) {
		super();
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.username = username;
	}

	public long getFormID() {
		return formID;
	}

	public void setFormID(long formID) {
		this.formID = formID;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "TuitionReimbursementForm [formID=" + formID + ", eventDate=" + eventDate + ", eventTime=" + eventTime
				+ ", location=" + location + ", description=" + description + ", cost=" + cost + ", gradingFormat="
				+ gradingFormat + ", eventType=" + eventType + ", justification=" + justification + ", username="
				+ username + "]";
	}
	
}