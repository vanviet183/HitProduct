package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
