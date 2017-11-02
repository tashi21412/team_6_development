package com.trms.model;

import java.sql.Time;
import java.util.Arrays;
import java.util.Calendar;

public class TuitionReimbursementForm {
	
	private Calendar eventDate;
	
	private Time eventTime;
	
	private String location = "";
	
	private String description = "";
	
	private double cost = 0;
	
	private String gradingFormat = "";
	
	private String eventType = "";
	
	private String justification = "";
	
	private String fileExtension = "";
	
	private byte[] fileByte;
	
	private String approvalAttachment = "";
	
	private byte[] emailByte;
			
	private long workTimeMissed = 0;

	public TuitionReimbursementForm() {
		super();
	}

	public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}

	public Time getEventTime() {
		return eventTime;
	}

	public void setEventTime(Time eventTime) {
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

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public byte[] getFileByte() {
		return fileByte;
	}

	public void setFileByte(byte[] fileByte) {
		this.fileByte = fileByte;
	}

	public String getApprovalAttachment() {
		return approvalAttachment;
	}

	public void setApprovalAttachment(String approvalAttachment) {
		this.approvalAttachment = approvalAttachment;
	}

	public byte[] getEmailByte() {
		return emailByte;
	}

	public void setEmailByte(byte[] emailByte) {
		this.emailByte = emailByte;
	}

	public long getWorkTimeMissed() {
		return workTimeMissed;
	}

	public void setWorkTimeMissed(long workTimeMissed) {
		this.workTimeMissed = workTimeMissed;
	}

	@Override
	public String toString() {
		return "TuitionReimbursementForm [eventDate=" + eventDate + ", eventTime=" + eventTime + ", location="
				+ location + ", description=" + description + ", cost=" + cost + ", gradingFormat=" + gradingFormat
				+ ", eventType=" + eventType + ", justification=" + justification + ", fileExtension=" + fileExtension
				+ ", fileByte=" + Arrays.toString(fileByte) + ", approvalAttachment=" + approvalAttachment
				+ ", emailByte=" + Arrays.toString(emailByte) + ", workTimeMissed=" + workTimeMissed + "]";
	}
	
}