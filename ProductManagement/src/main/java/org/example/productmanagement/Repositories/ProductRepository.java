package org.example.productmanagement.Repositories;

import org.example.productmanagement.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
