package com.nuce.movie.services;

public interface EmailService {
    void sendEmail(String toEmail, String body, String subject);
}
