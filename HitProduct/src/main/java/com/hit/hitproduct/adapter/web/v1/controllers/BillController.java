package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.services.BillService;
import com.hit.hitproduct.domains.dtos.BillDto;
import com.hit.hitproduct.domains.entities.DetailBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("")
    public ResponseEntity<?> getBills() {
        return VsResponseUtil.ok(billService.getBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBillById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(billService.getBillById(id));
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<?> createBill(@PathVariable("idUser") Long idUser, @RequestBody BillDto billDto, @RequestBody List<DetailBill> detailBills) throws MessagingException {
        return VsResponseUtil.ok(billService.createBill(idUser, billDto, detailBills));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(billService.deleteBill(id));
    }

}
