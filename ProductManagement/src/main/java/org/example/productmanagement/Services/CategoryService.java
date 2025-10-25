package org.example.productmanagement.Services;

import org.example.productmanagement.DTOs.CategoryDTO;
import org.example.productmanagement.Models.Category;
import org.example.productmanagement.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepo;

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

    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll()
                .stream()
                .map(category -> new CategoryDTO(category.getName(),category.getDescription()))
                .collect(Collectors.toList());
    }

    public Optional<CategoryDTO> getCategoryById(int id) {
        return categoryRepo.findById(id)
                .map (category -> new CategoryDTO(category.getName(),category.getDescription()));
    }

    public Optional<CategoryDTO> updateCategory(int id, CategoryDTO categoryDTO) {

        categoryRepo.findById(id)
                .ifPresent(category -> {
                    category.setName(categoryDTO.getName());
                    category.setDescription(categoryDTO.getDescription());
                    categoryRepo.save(category);
                });

        return getCategoryById(id);
    }

    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
}
