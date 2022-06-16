package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.applications.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class TestController {

    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping("/test")
    public ResponseEntity<?> testSendMail() throws MessagingException {
        emailSenderService.sendHtmlEmail("nguyenvanviet18032002@gmail.com", "Hit Sneaker Shop With Love");
        return ResponseEntity.ok().body("Send mail success");

    }
}
