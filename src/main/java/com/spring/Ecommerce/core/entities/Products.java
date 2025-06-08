package com.spring.Ecommerce.core.entities;


import com.spring.Ecommerce.core.enums.TypeProduct;

import java.math.BigDecimal;

public record Products(Long id,
                       String nameProduct,
                       String descriptionProduct,
                       int quantityProduct,
                       BigDecimal productValue,
                       TypeProduct typeProduct) {}