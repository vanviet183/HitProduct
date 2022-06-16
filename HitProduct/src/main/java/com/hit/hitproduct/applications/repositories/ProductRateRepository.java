package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRateRepository extends JpaRepository<ProductRate, Long> {

}
