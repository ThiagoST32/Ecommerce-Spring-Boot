package com.spring.Ecommerce.core.entities;


import com.spring.Ecommerce.core.enums.TypeProduct;

import java.math.BigDecimal;
import java.util.Objects;

public final class Products {
    Long id;
    String nameProduct;
    String descriptionProduct;
    int quantityProduct;
    BigDecimal productValue;
    TypeProduct typeProduct;

    public Products(String nameProduct, String descriptionProduct, int quantityProduct, BigDecimal productValue, TypeProduct typeProduct) {
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.quantityProduct = quantityProduct;
        this.productValue = productValue;
        this.typeProduct = typeProduct;
    }

    public Long id() {
        return id;
    }

    public String nameProduct() {
        return nameProduct;
    }

    public String descriptionProduct() {
        return descriptionProduct;
    }

    public int quantityProduct() {
        return quantityProduct;
    }

    public BigDecimal productValue() {
        return productValue;
    }

    public TypeProduct typeProduct() {
        return typeProduct;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Products) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.nameProduct, that.nameProduct) &&
                Objects.equals(this.descriptionProduct, that.descriptionProduct) &&
                this.quantityProduct == that.quantityProduct &&
                Objects.equals(this.productValue, that.productValue) &&
                Objects.equals(this.typeProduct, that.typeProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, descriptionProduct, quantityProduct, productValue, typeProduct);
    }

    @Override
    public String toString() {
        return "Products[" +
                "id=" + id + ", " +
                "nameProduct=" + nameProduct + ", " +
                "descriptionProduct=" + descriptionProduct + ", " +
                "quantityProduct=" + quantityProduct + ", " +
                "productValue=" + productValue + ", " +
                "typeProduct=" + typeProduct + ']';
    }
}