package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.NotificationDto;
import com.hit.hitproduct.domains.entities.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    List<Notification> getNotifications();

    Notification getNotificationById(Long id);

    // Notification of system
    Notification createNotification(NotificationDto NotificationDto);

    // Notification of user
    Notification createNotificationForUser(Long idUser, NotificationDto notificationDto);

    Notification updateNotification(Long id, NotificationDto notificationDto);

    TrueFalseResponse deleteNotification(Long id);
}
