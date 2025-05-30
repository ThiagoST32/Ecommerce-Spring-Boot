package com.spring.Ecommerce.core.entities;


import com.spring.Ecommerce.core.enums.typeProduct;

import java.math.BigDecimal;

public class Products {

    public Products(String nameProduct, int quantityProduct, BigDecimal productValue, typeProduct typeProduct) {
        this.nameProduct = nameProduct;
        this.quantityProduct = quantityProduct;
        this.productValue = productValue;
        this.typeProduct = typeProduct;
    }

    private Long id;
    private String nameProduct;
    private int quantityProduct;
    private BigDecimal productValue;
    private typeProduct typeProduct;
}
