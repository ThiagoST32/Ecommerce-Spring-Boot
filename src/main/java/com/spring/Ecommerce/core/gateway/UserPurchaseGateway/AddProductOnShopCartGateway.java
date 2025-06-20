package com.spring.Ecommerce.core.gateway.UserPurchaseGateway;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;

public interface AddProductOnShopCartGateway {
    ShopCart execute(Products products);
}
