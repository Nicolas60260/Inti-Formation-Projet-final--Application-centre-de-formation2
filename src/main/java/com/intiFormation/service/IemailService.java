package com.intiFormation.service;

public interface IemailService {
	public void sendSimpleMessage(String to, String subject, String text);
	public void scheduleEmail(String to, String subject, String text, long delay);
}
