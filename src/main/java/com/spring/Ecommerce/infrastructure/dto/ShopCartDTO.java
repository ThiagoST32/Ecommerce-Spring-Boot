package com.spring.Ecommerce.infrastructure.dto;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;

import java.math.BigDecimal;
import java.util.List;

public record ShopCartDTO(List<Products> productsList, BigDecimal totalValue, UsersEntity user, Integer quantity) {
}
