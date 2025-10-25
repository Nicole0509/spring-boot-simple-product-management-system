package org.example.productmanagement.Services;

import org.example.productmanagement.Repositories.CategoryRepository;
import org.example.productmanagement.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public ProductCategoryService(CategoryRepository categoryRepo, ProductRepository productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }
}
