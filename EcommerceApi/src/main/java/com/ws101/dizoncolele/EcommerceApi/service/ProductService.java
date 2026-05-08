package com.ws101.dizoncolele.EcommerceApi.service;

import com.ws101.dizoncolele.EcommerceApi.dto.CreateProductDto;
import com.ws101.dizoncolele.EcommerceApi.model.Product;
import com.ws101.dizoncolele.EcommerceApi.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Layer using JPA Repository + DTO Support
 */
@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    // =========================
    // EXISTING METHODS (UNCHANGED)
    // =========================

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Product> getByCategory(String name) {
        return repo.findByCategoryName(name);
    }

    public List<Product> getByPriceRange(double min, double max) {
        return repo.findProductsByPriceRange(min, max);
    }

    // =========================
    // EXISTING ENTITY METHODS
    // (keep for backward compatibility)
    // =========================

    public Product create(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product updated) {
        Product existing = getProduct(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        return repo.save(existing);
    }

    // =========================
    // DTO METHODS (NEW - REQUIRED FOR LAB 9)
    // =========================

    public Product createFromDto(CreateProductDto dto) {
        Product product = new Product();
        product.setName(dto.prodName());
        product.setPrice(dto.prodPrice());
        product.setDescription(dto.prodDescription());
        product.setQuantity(dto.quantity());

        return repo.save(product);
    }

    public Product updateFromDto(Long id, CreateProductDto dto) {
        Product existing = getProduct(id);

        existing.setName(dto.prodName());
        existing.setPrice(dto.prodPrice());
        existing.setDescription(dto.prodDescription());
        existing.setQuantity(dto.quantity());

        return repo.save(existing);
    }
}