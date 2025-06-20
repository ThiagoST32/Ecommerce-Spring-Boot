package com.spring.Ecommerce.core.useCases.ShopCart;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;

public interface AddProductOnShopCartUseCase {
    ShopCart execute(Products products);
}
