package com.nuce.movie.servicesImpl;

import com.nuce.movie.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String toEmail,String body,String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("phanhuyhoang783@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        message.setTo(toEmail);
        mailSender.send(message);
    }
}
