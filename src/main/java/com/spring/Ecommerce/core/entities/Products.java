package com.spring.Ecommerce.core.entities;
import com.spring.Ecommerce.core.enums.TypeProduct;

import java.math.BigDecimal;
import java.util.Objects;

public class Products {
    Long id;
    String nameProduct;
    String descriptionProduct;
    int quantityProduct;
    BigDecimal productValue;
    TypeProduct typeProduct;

    public Products(){};

    public Products(String nameProduct, String descriptionProduct, int quantityProduct, BigDecimal productValue, TypeProduct typeProduct) {
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.quantityProduct = quantityProduct;
        this.productValue = productValue;
        this.typeProduct = typeProduct;
    }
    public Products(Long id, String nameProduct, String descriptionProduct, int quantityProduct, BigDecimal productValue, TypeProduct typeProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.quantityProduct = quantityProduct;
        this.productValue = productValue;
        this.typeProduct = typeProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
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