package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.User;
import com.hit.hitproduct.domains.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByToken(String token);

    List<VerificationToken> findByStatus(Boolean status);

    Optional<VerificationToken> findVerificationTokensByUser(User user);
}
