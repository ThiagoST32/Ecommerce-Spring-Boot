package com.spring.Ecommerce.core.entities;


import com.spring.Ecommerce.core.enums.typeProduct;

import java.math.BigDecimal;

public record Products(Long id,
                       String nameProduct,
                       int quantityProduct,
                       BigDecimal productValue,
                       typeProduct typeProduct) {}