package com.ws101.dizoncolele.EcommerceApi.controller;

import com.ws101.dizoncolele.EcommerceApi.dto.CreateProductDto;
import com.ws101.dizoncolele.EcommerceApi.model.Product;
import com.ws101.dizoncolele.EcommerceApi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Product API (SECURED + DTO VALIDATED)
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // =========================
    // PUBLIC ENDPOINTS
    // =========================

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @GetMapping("/category/{name}")
    public List<Product> getByCategory(@PathVariable String name) {
        return service.getByCategory(name);
    }

    @GetMapping("/price")
    public List<Product> getByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }

    // =========================
    // ADMIN ONLY ENDPOINTS (DTO VALIDATION APPLIED)
    // =========================

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product create(@Valid @RequestBody CreateProductDto dto) {
        return service.createFromDto(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product update(
            @PathVariable Long id,
            @Valid @RequestBody CreateProductDto dto) {

        return service.updateFromDto(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}