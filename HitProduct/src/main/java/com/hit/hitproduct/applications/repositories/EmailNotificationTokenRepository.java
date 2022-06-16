package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.EmailNotificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailNotificationTokenRepository extends JpaRepository<EmailNotificationToken, Long> {

    Optional<EmailNotificationToken> findByToken(String token);

    List<EmailNotificationToken> findByStatus(Boolean status);

//    Optional<EmailNotification> findVerificationTokensByUser(EmailNotification emailNotification);
}
