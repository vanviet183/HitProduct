package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {


}
