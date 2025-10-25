package org.example.productmanagement.Repositories;

import org.example.productmanagement.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
