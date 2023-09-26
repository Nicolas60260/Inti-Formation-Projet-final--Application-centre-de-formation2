package com.intiFormation.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements IemailService {

	@Autowired
	private JavaMailSender emailSender;

	public void scheduleEmail(String to, String subject, String text, long delay) {
        // Planifiez l'envoi de l'e-mail avec un délai spécifié
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> sendSimpleMessage(to, subject, text), delay, TimeUnit.MILLISECONDS);
    }
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("gestionformation16@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
}
