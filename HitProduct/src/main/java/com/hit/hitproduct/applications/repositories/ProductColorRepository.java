package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

    List<ProductColor> findBySlug(String slug);
}
