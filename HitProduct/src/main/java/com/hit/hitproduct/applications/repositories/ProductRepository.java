package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBySlug(String nameProduct);

    List<Product> findBySlugContaining(@Param("nameProduct") String nameProduct);

}
