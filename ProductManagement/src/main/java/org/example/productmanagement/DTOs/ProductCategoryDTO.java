package org.example.productmanagement.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.productmanagement.Models.Category;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDTO {
    private String productName;
    private double price;
    private Set<String> categories;
}
