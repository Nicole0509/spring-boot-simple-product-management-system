package org.example.productmanagement.Services;

import org.example.productmanagement.DTOs.CategoryDTO;
import org.example.productmanagement.Models.Category;
import org.example.productmanagement.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        categoryRepo.save(category);

        return categoryDTO;
    }
}
