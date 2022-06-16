package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByProduct_Id(Long id);
}
