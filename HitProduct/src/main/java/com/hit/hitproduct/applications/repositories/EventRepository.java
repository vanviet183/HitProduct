package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
