package com.ws101.dizoncolele.EcommerceApi.dto;

public record ProductListingEntry(
        Long prodId,
        String prodName,
        double prodPrice
) {}