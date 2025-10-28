package org.example.productmanagement.Repositories;

import org.example.productmanagement.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByName(String name);
    boolean existsByName(String name);
    boolean existsById(Integer id);
}
