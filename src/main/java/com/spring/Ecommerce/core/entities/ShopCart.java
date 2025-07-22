package com.spring.Ecommerce.core.entities;

import java.math.BigDecimal;
import java.util.List;

public class ShopCart {
    private Long id_shopCart;
    private List<Products> productsList;
    private BigDecimal totalPrice;
    private Long id_user;

    public ShopCart(Long id_shopCart, List<Products> products, BigDecimal totalPrice, Long id_user) {
        this.id_shopCart = id_shopCart;
        this.productsList = products;
        this.totalPrice = totalPrice;
        this.id_user = id_user;
    }

    public ShopCart(List<Products> products, BigDecimal totalPrice, Long id_user) {
        this.productsList = products;
        this.totalPrice = totalPrice;
        this.id_user = id_user;
    }

    public Long getId_shopCart() {
        return id_shopCart;
    }

    public void setId_shopCart(Long id_shopCart) {
        this.id_shopCart = id_shopCart;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}
