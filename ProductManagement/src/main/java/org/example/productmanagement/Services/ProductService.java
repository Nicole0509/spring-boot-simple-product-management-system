package org.example.productmanagement.Services;

import org.example.productmanagement.DTOs.ProductDTO;
import org.example.productmanagement.Exceptions.ResourceAlreadyExists;
import org.example.productmanagement.Exceptions.ResourceNotFound;
import org.example.productmanagement.Models.Product;
import org.example.productmanagement.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        //Check if a product already exists
        if (productRepo.existsByName(productDTO.getName())) {
            throw new ResourceAlreadyExists("Product with name '" + productDTO.getName() + "' already exists");
        }

        //Create a new Product
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

    public ProductDTO getProductById(int id) {

        return productRepo.findById(id)
                .map(product -> new ProductDTO(product.getName(),product.getPrice()))
                .orElseThrow(() -> new ResourceNotFound("Product with id " + id + " was not found"));
    }

    public ProductDTO updateProductById(int id, ProductDTO productDTO) {

        //Check if a product id already exists
        if (!productRepo.existsById(id)) {
            throw new ResourceNotFound("Product with name '" + productDTO.getName() + "'  and id '"+ id + "' was not found");
        }

        //Update existing product
         productRepo.findById(id).ifPresent(product -> {
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            productRepo.save(product);
        });

         return getProductById(id);
    }

    public void deleteProductById(int id) {

        //Check if a product id already exists
        if (!productRepo.existsById(id)) {
            throw new ResourceNotFound("Product with id '"+ id + "' was not found");
        }
        productRepo.deleteById(id);
    }
}
