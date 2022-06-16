package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.applications.repositories.ProductRepository;
import com.hit.hitproduct.applications.repositories.ProductSizeRepository;
import com.hit.hitproduct.applications.services.ProductSizeService;
import com.hit.hitproduct.configs.exceptions.NotFoundException;
import com.hit.hitproduct.domains.dtos.ProductSizeDto;
import com.hit.hitproduct.domains.entities.Product;
import com.hit.hitproduct.domains.entities.ProductSize;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSizeServiceImpl implements ProductSizeService {

    @Autowired
    ProductSizeRepository productSizeRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductSize> getAll() {
        return productSizeRepository.findAll();
    }

    @Override
    public ProductSize getProductSizeById(Long id) {
        Optional<ProductSize> productSize = productSizeRepository.findById(id);
        checkProductSizeException(productSize);
        return productSize.get();
    }

    @Override
    @Transactional
    public List<ProductSize> createListProductSize(Long idProduct, List<ProductSizeDto> productSizeDtos) {
        Optional<Product> product = productRepository.findById(idProduct);
        checkProductException(product);

        List<ProductSize> productSizes = new ArrayList<>();
        productSizeDtos.forEach(productSizeDto -> {
            productSizes.add(createOrUpdate(product.get(), new ProductSize(), productSizeDto));
        });
        return productSizes;
    }

    @Override
    public ProductSize updateProductSize(Long idProduct, Long id, ProductSizeDto productSizeDto) {
        Optional<Product> product = productRepository.findById(idProduct);
        checkProductException(product);

        Optional<ProductSize> productSize = productSizeRepository.findById(id);
        checkProductSizeException(productSize);

        return createOrUpdate(product.get(), productSize.get(), productSizeDto);
    }

    private ProductSize createOrUpdate(Product product, ProductSize productSize, ProductSizeDto productSizeDto) {
        modelMapper.map(productSizeDto, productSize);
        productSize.setProduct(product);

        return productSizeRepository.save(productSize);
    }

    @Override
    public TrueFalseResponse deleteProductSize(Long id) {
        return null;
    }

    private void checkProductSizeException(Optional<ProductSize> productSize) {
        if(productSize.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkProductException(Optional<Product> product) {
        if(product.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }
}
