package com.spring.Ecommerce.core.gateway.UserPurchaseGateway;

import com.spring.Ecommerce.core.entities.ShopCart;

public interface RemoveProductsOnShopCartByNameGateway {
    ShopCart execute(String name);
}
