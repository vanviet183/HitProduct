package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.services.ProductRateService;
import com.hit.hitproduct.domains.dtos.ProductRateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product_rates")
public class ProductRateController {
    
    @Autowired
    ProductRateService productRateService;

    @GetMapping("")
    public ResponseEntity<?> getProductRates() {
        return VsResponseUtil.ok(productRateService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductRate(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productRateService.getProductRateById(id));
    }

    @PostMapping("/{idProduct}/{idUser}")
    public ResponseEntity<?> createProductRate(@PathVariable("idProduct") Long idProduct, @PathVariable("idUser") Long idUser, @RequestBody ProductRateDto productRateDto) {
        return VsResponseUtil.ok(productRateService.createProductRate(idProduct, idUser, productRateDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProductRate(@PathVariable("id") Long id, @RequestBody ProductRateDto productRateDto) {
        return VsResponseUtil.ok(productRateService.updateProductRate(id, productRateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductRate(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productRateService.deleteProductRate(id));
    }
}
