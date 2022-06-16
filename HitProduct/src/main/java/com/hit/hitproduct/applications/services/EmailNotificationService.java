package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.domains.dtos.EmailNotificationDto;
import com.hit.hitproduct.domains.entities.EmailNotification;
import org.springframework.stereotype.Service;

@Service
public interface EmailNotificationService {

    EmailNotification signUpEmailNotification(EmailNotificationDto emailNotificationDto);
}
