package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.CategoryDto;
import com.hit.hitproduct.domains.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {

    List<Category> getAll();

    Category getCategoryById(Long id);

    Category createCategory(CategoryDto categoryDto);

    Category updateCategory(Long id, CategoryDto categoryDto);

    TrueFalseResponse deleteCategory(Long id);

}
