package com.spring.Ecommerce.infrastructure.services.ShopCart;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.ShopCartGateway.AddProductOnShopCartGateway;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.mapper.ShopCartMapper;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddProductOnShopCartImp implements AddProductOnShopCartGateway {
    private final ShopCartMapper shopCartMapper;
    private final ProductMapper productMapper;

    @Autowired
    public AddProductOnShopCartImp(ShopCartMapper shopCartMapper, ProductMapper productMapper){
        this.shopCartMapper = shopCartMapper;
        this.productMapper = productMapper;
    }

    @Override
    public ShopCart execute(Products products, User user) {
        //Fazer um getById para pegar o produto -> ShopCartController;
        var productList = this.productMapper.mapToPersistenceProductList(products);
        BigDecimal total = productList.stream().map(ProductEntity::getProductValue).reduce(BigDecimal.ZERO, BigDecimal::add);

        ShopCartEntity cart = new ShopCartEntity();
        cart.setId_user(user.getId_user());
        cart.setProductsList(productList);
        cart.setTotalValue(total);

        return this.shopCartMapper.mapToDomainShopCart(cart);
    }
}
