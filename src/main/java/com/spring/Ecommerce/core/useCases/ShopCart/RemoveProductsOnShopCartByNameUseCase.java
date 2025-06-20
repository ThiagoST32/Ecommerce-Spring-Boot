package com.spring.Ecommerce.core.useCases.ShopCart;

import com.spring.Ecommerce.core.entities.ShopCart;

public interface RemoveProductsOnShopCartByNameUseCase {
    ShopCart execute(String name);
}
