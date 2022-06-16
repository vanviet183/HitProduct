package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.ProductSizeDto;
import com.hit.hitproduct.domains.entities.ProductSize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductSizeService {

    List<ProductSize> getAll();

    ProductSize getProductSizeById(Long id);

    List<ProductSize> createListProductSize(Long idProduct, List<ProductSizeDto> productSizeDtos);

    ProductSize updateProductSize(Long idProduct, Long id, ProductSizeDto productSizeDto);

    TrueFalseResponse deleteProductSize(Long id);
}
