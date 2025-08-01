package com.spring.Ecommerce.core.entities;

import java.math.BigDecimal;
import java.util.List;

public class ShopCart {
    private Long id_shopCart;
    private List<Products> productsList;
    private BigDecimal totalPrice;
    private User user;

    public ShopCart(Long id_shopCart, List<Products> products, BigDecimal totalPrice, User user) {
        this.id_shopCart = id_shopCart;
        this.productsList = products;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public ShopCart(List<Products> products, BigDecimal totalPrice, User user) {
        this.productsList = products;
        this.totalPrice = totalPrice;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
