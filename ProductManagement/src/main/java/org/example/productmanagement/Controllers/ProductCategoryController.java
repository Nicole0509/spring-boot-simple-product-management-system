package org.example.productmanagement.Controllers;

import org.example.productmanagement.Models.Product;
import org.example.productmanagement.Services.ProductCategoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/{productId}/category/{categoryId}")
    public Product assignCategory(@PathVariable int productId,@PathVariable int categoryId){
        return productCategoryService.assignCategoryToProduct(productId,categoryId);
    }
}
