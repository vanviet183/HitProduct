package com.hit.hitproduct.applications.repositories;


import com.hit.hitproduct.domains.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
