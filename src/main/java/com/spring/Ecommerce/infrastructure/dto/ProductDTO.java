package com.spring.Ecommerce.infrastructure.dto;

import com.spring.Ecommerce.core.enums.TypeProduct;

import java.math.BigDecimal;

public record ProductDTO (String productName, String descriptionProduct, int quantity, BigDecimal productValue, TypeProduct typeProduct) {}
