package com.example.fordleapi2.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {



    private JavaMailSender javaMailSender;

    public void sendRegistrationEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome! Registration Successful");
        message.setText("Thank you for registering. Welcome to our platform!");

        javaMailSender.send(message);
    }
}
