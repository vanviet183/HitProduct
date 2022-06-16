package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.services.ProductColorService;
import com.hit.hitproduct.domains.dtos.ProductColorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productColors")
public class ProductColorController {

    @Autowired
    ProductColorService productColorService;

    @GetMapping("")
    public ResponseEntity<?> getProductColors() {
        return VsResponseUtil.ok(productColorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductColor(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productColorService.getProductColorById(id));
    }

    @PostMapping("/{idProduct}")
    public ResponseEntity<?> createProductColor(@PathVariable("idProduct") Long idProduct, @RequestBody List<ProductColorDto> productColorDtos) {
        return VsResponseUtil.ok(productColorService.createListProductColor(idProduct, productColorDtos));
    }

    @PatchMapping("/{idProduct}/{id}")
    public ResponseEntity<?> updateProductColor(@PathVariable("idProduct") Long idProduct, @PathVariable("id") Long id, @RequestBody ProductColorDto productColorDto) {
        return VsResponseUtil.ok(productColorService.updateProductColor(idProduct, id, productColorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductColor(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productColorService.deleteProductColor(id));
    }
}
