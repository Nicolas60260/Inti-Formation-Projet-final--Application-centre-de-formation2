package com.intiFormation.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmailScheduleRequest {
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
	private Date scheduledTime;
	private String recipient;
	private String subject;
	private String text;

	public EmailScheduleRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailScheduleRequest(Date scheduledTime, String recipient, String subject, String text) {
		super();
		this.scheduledTime = scheduledTime;
		this.recipient = recipient;
		this.subject = subject;
		this.text = text;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "EmailScheduleRequest [scheduledTime=" + scheduledTime + ", recipient=" + recipient + ", subject="
				+ subject + ", text=" + text + "]";
	}

}
