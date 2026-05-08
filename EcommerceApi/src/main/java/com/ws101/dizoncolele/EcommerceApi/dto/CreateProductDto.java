package com.ws101.dizoncolele.EcommerceApi.dto;

import jakarta.validation.constraints.*;

public record CreateProductDto(

        @NotBlank(message = "Product name is required")
        String prodName,

        @Positive(message = "Price must be positive")
        double prodPrice,

        @NotBlank(message = "Description is required")
        String prodDescription,

        @Positive(message = "Stock must be positive")
        int quantity
) {}