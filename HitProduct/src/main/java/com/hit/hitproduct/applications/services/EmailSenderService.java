package com.hit.hitproduct.applications.services;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailSenderService {
    void sendSimpleEmail(String toEmail, String body, String subject);
    void sendHtmlEmail(String toEmail, String subject) throws MessagingException;
}
