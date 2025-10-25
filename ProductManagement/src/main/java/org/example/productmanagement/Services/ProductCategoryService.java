package org.example.productmanagement.Services;

import org.example.productmanagement.Models.Category;
import org.example.productmanagement.Models.Product;
import org.example.productmanagement.Repositories.CategoryRepository;
import org.example.productmanagement.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCategoryService {
    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public ProductCategoryService(CategoryRepository categoryRepo, ProductRepository productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    public Product assignCategoryToProduct(int productId, int categoryId){

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.getCategories().add(category);

//        category.getProducts().add(product);

        return productRepo.save(product);
    }
}
