package org.example.productmanagement.Controllers;

import org.example.productmanagement.DTOs.ProductDTO;
import org.example.productmanagement.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable int id, @RequestBody ProductDTO productDTO){
        return productService.updateProductById(id, productDTO);
    }
}
