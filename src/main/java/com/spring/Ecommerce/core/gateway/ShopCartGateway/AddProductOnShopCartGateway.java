package com.spring.Ecommerce.core.gateway.ShopCartGateway;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;

import java.util.List;

public interface AddProductOnShopCartGateway {
    ShopCart execute(Products products);
}
