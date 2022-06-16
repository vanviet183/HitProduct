package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.applications.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleEmail(String toEmail, String body, String subject) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("vanvietgg183@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

    }

    @Override
    public void sendHtmlEmail(String toEmail, String subject) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h3 style=\"text-align: center;\">Thank you very much. Have a nice day!</h3>"
                +"<img src='https://res.cloudinary.com/vitvn183/image/upload/v1655110510/productHit_lctbql.png' style=\"width:700px;height:500px;display: flex;margin: auto;\">";

        helper.setTo(toEmail);

        message.setContent(htmlMsg, "text/html");

        helper.setSubject(subject);


        this.javaMailSender.send(message);

    }
}
