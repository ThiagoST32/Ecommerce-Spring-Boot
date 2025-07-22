package com.spring.Ecommerce.infrastructure.services.ShopCart;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.core.gateway.ShopCartGateway.AddProductOnShopCartGateway;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.mapper.ShopCartMapper;
import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AddProductOnShopCartImp implements AddProductOnShopCartGateway {
    private final ShopCartMapper shopCartMapper;
    private final ProductMapper productMapper;

    @Autowired
    public AddProductOnShopCartImp(ShopCartMapper shopCartMapper, ProductMapper productMapper) {
        this.shopCartMapper = shopCartMapper;
        this.productMapper = productMapper;
    }

    @Override
    public ShopCart execute(Products products) {
        //Fazer um getById para pegar o produto -> ShopCartController;
        ShopCartEntity cart = new ShopCartEntity();
        var prod = Collections.singletonList(this.productMapper.mapToPersistenceProduct(products));
        cart.setProductsList(prod);
        return this.shopCartMapper.mapToDomainShopCart(cart);
    }
}
