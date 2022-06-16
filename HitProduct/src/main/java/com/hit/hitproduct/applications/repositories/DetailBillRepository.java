package com.hit.hitproduct.applications.repositories;

import com.hit.hitproduct.domains.entities.DetailBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailBillRepository extends JpaRepository<DetailBill, Long> {

    DetailBill findByBill_Id(Long idBill);

    List<DetailBill> findByUser_IdAndBillFalse(Long idUser);
}
