package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByUser_Id(Long idUser);
}
