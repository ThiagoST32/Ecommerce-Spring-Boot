package com.spring.Ecommerce.infrastructure.services.ShopCart;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.ShopCartGateway.AddProductOnShopCartGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
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
    private final UserEntityMapper userEntityMapper;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public AddProductOnShopCartImp(ShopCartMapper shopCartMapper, ProductMapper productMapper, UserEntityMapper userEntityMapper, UserEntityRepository userEntityRepository){
        this.shopCartMapper = shopCartMapper;
        this.productMapper = productMapper;
        this.userEntityMapper = userEntityMapper;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public ShopCart execute(Products products, User user) {
        //Fazer um getById para pegar o produto -> ShopCartController;
        var productList = this.productMapper.mapToPersistenceProductList(products);
        UsersEntity users = this.userEntityRepository.findByName(this.userEntityMapper.mapToPersistenceUser(user).getName());

        BigDecimal total = BigDecimal.ZERO;

        ShopCartEntity cart = new ShopCartEntity();
        cart.setUsersEntity(users);
        cart.setProductsList(productList);
        cart.setTotalValue(total);

        return this.shopCartMapper.mapToDomainShopCart(cart);
    }
}
