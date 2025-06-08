package com.spring.Ecommerce.core.entities;

import java.math.BigDecimal;
import java.util.List;

public record ShopCart(
        Long id_shopCart,
        List<Products> products,
        BigDecimal totalPrice,
        Long id_user ) {}
