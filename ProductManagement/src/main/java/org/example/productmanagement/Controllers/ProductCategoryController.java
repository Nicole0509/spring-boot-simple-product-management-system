package org.example.productmanagement.Controllers;

import org.example.productmanagement.DTOs.ProductCategoryDTO;
import org.example.productmanagement.Services.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/{productId}/category/{categoryId}")
    public ProductCategoryDTO assignCategory(@PathVariable int productId, @PathVariable int categoryId){
        return productCategoryService.assignCategoryToProduct(productId,categoryId);
    }

    @DeleteMapping("/{productId}/category/{categoryId}")
    public ProductCategoryDTO removeCategoryFromProduct(@PathVariable int productId, @PathVariable int categoryId){
        return productCategoryService.removeCategoryFromProduct(productId,categoryId);
    }
}
