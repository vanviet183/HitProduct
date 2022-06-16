package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.services.DetailBillService;
import com.hit.hitproduct.domains.dtos.DetailBillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/detail_bills")
public class DetailBillController {

    @Autowired
    DetailBillService detailBillService;

    @GetMapping("")
    public ResponseEntity<?> getDetailBills() {
        return VsResponseUtil.ok(detailBillService.getDetailBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailBillById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(detailBillService.getDetailBillById(id));
    }

    @GetMapping("/{idUser}/cart")
    public ResponseEntity<?> getListProductInCart(@PathVariable("idUser") Long idUser) {
        return VsResponseUtil.ok(detailBillService.getListProductInCart(idUser));
    }

    @PostMapping("/{idUser}/{idProduct}")
    public ResponseEntity<?> createDetailBill(@PathVariable("idUser") Long idUser, @PathVariable("idProduct") Long idProduct, @RequestBody DetailBillDto detailBillDto) {
        return VsResponseUtil.ok(detailBillService.createDetailBill(idUser, idProduct, detailBillDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateDetailBill(@PathVariable("id") Long id, @RequestBody DetailBillDto detailBillDto) {
        return VsResponseUtil.ok(detailBillService.updateDetailBill(id, detailBillDto));
    }

//    @PostMapping("/{idDetailBill}/pay")
//    public ResponseEntity<?> pay(@PathVariable("idDetailBill") Long idDetailBill, @RequestBody BillDto billDto) {
//        return VsResponseUtil.ok(detailBillService.pay(idDetailBill, billDto));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetailBill(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(detailBillService.deleteDetailBill(id));
    }

}
