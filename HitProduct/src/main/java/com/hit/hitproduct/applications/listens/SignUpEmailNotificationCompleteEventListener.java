package com.hit.hitproduct.applications.listens;

import com.hit.hitproduct.applications.events.SignUpEmailNotifyCompleteEvent;
import com.hit.hitproduct.applications.services.EmailSenderService;
import com.hit.hitproduct.applications.services.VerificationTokenService;
import com.hit.hitproduct.domains.entities.EmailNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class SignUpEmailNotificationCompleteEventListener implements ApplicationListener<SignUpEmailNotifyCompleteEvent> {

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    EmailSenderService emailSenderService;

    @Override
    public void onApplicationEvent(SignUpEmailNotifyCompleteEvent event) {
        // Create the Verification Token for the User with link
        EmailNotification emailNotification = event.getEmailNotification();
        String token = UUID.randomUUID().toString();

        verificationTokenService.saveVerificationTokenForEmailNotification(token, emailNotification);

        // Send email to user
        log.info(event.getApplicationUrl());
        String url = event.getApplicationUrl()
                + "/verifyEmailNotification?token="
                + token;
        emailSenderService.sendSimpleEmail(emailNotification.getEmail(), url, "Verify Sign Up Notification VitApp Web");

        log.info("Click the link to verify your account: {}", url);
    }
}
