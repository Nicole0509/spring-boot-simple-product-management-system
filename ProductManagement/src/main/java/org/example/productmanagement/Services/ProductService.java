package org.example.productmanagement.Services;

import org.example.productmanagement.DTOs.ProductDTO;
import org.example.productmanagement.Models.Product;
import org.example.productmanagement.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        productRepo.save(product);

        return productDTO;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(product -> new ProductDTO(product.getName(),product.getPrice()))
                .collect(Collectors.toList());
    }

    public ProductDTO updateProductById(int id, ProductDTO productDTO) {
         productRepo.findById(id).ifPresent(product -> {
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            productRepo.save(product);
        });

         return productDTO;
    }
}
