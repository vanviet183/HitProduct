package com.hit.hitproduct.applications.services.impl;

import com.github.slugify.Slugify;
import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.applications.repositories.ProductColorRepository;
import com.hit.hitproduct.applications.repositories.ProductRepository;
import com.hit.hitproduct.applications.services.ProductColorService;
import com.hit.hitproduct.configs.exceptions.NotFoundException;
import com.hit.hitproduct.domains.dtos.ProductColorDto;
import com.hit.hitproduct.domains.entities.Product;
import com.hit.hitproduct.domains.entities.ProductColor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductColorServiceImpl implements ProductColorService {

    @Autowired
    ProductColorRepository productColorRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductColor> getAll() {
        return productColorRepository.findAll();
    }

    @Override
    public ProductColor getProductColorById(Long id) {
        Optional<ProductColor> productColor = productColorRepository.findById(id);
        checkProductColorException(productColor);
        return productColor.get();
    }

    @Override
    @Transactional
    public List<ProductColor> createListProductColor(Long idProduct, List<ProductColorDto> productColorDtos) {
        Optional<Product> product = productRepository.findById(idProduct);
        checkProductException(product);

        List<ProductColor> productColors = new ArrayList<>();
        productColorDtos.forEach(productColorDto -> {
            productColors.add(createOrUpdate(product.get(), new ProductColor(), productColorDto));
        });
        return productColors;
    }

    @Override
    public ProductColor updateProductColor(Long idProduct, Long id, ProductColorDto productColorDto) {
        Optional<Product> product = productRepository.findById(idProduct);
        checkProductException(product);

        Optional<ProductColor> productColor = productColorRepository.findById(id);
        checkProductColorException(productColor);

        return createOrUpdate(product.get(), productColor.get(), productColorDto);
    }


    private ProductColor createOrUpdate(Product product, ProductColor productColor, ProductColorDto productColorDto) {
        modelMapper.map(productColorDto, productColor);

        Slugify slug = new Slugify();
        String result = slug.slugify(productColorDto.getColor());
        productColor.setSlug(result);

        productColor.setProduct(product);

        return productColorRepository.save(productColor);
    }

    @Override
    public TrueFalseResponse deleteProductColor(Long id) {
        Optional<ProductColor> productColor = productColorRepository.findById(id);
        checkProductColorException(productColor);
        productColorRepository.deleteById(id);
        return new TrueFalseResponse(true);
    }

    private void checkProductColorException(Optional<ProductColor> productColor) {
        if(productColor.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkProductException(Optional<Product> product) {
        if(product.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

}
