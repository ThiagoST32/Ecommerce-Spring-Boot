package com.spring.Ecommerce.core.gateway.ShopCartGateway;

import com.spring.Ecommerce.core.entities.ShopCart;

public interface GetProductsOnShopCarByTypeGateway {
    ShopCart execute(String typeProduct);
}
