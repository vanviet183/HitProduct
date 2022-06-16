package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends JpaRepository<Help, Long> {

}
