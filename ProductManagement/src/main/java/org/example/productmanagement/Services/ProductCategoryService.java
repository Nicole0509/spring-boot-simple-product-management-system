package org.example.productmanagement.Services;

import org.example.productmanagement.DTOs.ProductCategoryDTO;
import org.example.productmanagement.Models.Category;
import org.example.productmanagement.Models.Product;
import org.example.productmanagement.Repositories.CategoryRepository;
import org.example.productmanagement.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public ProductCategoryService(CategoryRepository categoryRepo, ProductRepository productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    public ProductCategoryDTO assignCategoryToProduct(int productId, int categoryId){

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();

        product.getCategories().add(category);

        category.getProducts().add(product);

        productRepo.save(product);

        return new ProductCategoryDTO(
                product.getName(),
                product.getPrice(),
                product.getCategories()
                        .stream()
                        .map(Category::getName)
                        .collect(Collectors.toSet())
        );
    }

    public ProductCategoryDTO removeCategoryFromProduct(int productId, int categoryId){
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();

        product.getCategories().remove(category);

        category.getProducts().remove(product);

        productRepo.save(product);

        return new ProductCategoryDTO(
                product.getName(),
                product.getPrice(),
                product.getCategories()
                        .stream()
                        .map(Category::getName)
                        .collect(Collectors.toSet())
        );
    }
}
