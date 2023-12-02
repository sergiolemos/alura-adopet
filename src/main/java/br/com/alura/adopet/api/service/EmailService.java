package br.com.alura.adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmail(String to, String subject, String message){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("contato@sergiolemos.com");
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);
        emailSender.send(email);
    }
}
