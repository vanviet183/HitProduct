package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.applications.repositories.EmailNotificationRepository;
import com.hit.hitproduct.applications.services.EmailNotificationService;
import com.hit.hitproduct.domains.dtos.EmailNotificationDto;
import com.hit.hitproduct.domains.entities.EmailNotification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EmailNotificationRepository emailNotificationRepository;

    @Override
    public EmailNotification signUpEmailNotification(EmailNotificationDto emailNotificationDto) {
        EmailNotification emailNotification = modelMapper.map(emailNotificationDto, EmailNotification.class);
        return emailNotificationRepository.save(emailNotification);
    }
}
