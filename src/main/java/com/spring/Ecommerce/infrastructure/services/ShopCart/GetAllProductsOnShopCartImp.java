package com.spring.Ecommerce.infrastructure.services.ShopCart;


import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.core.gateway.ShopCartGateway.GetAllProductsOnShopCartGateway;
import com.spring.Ecommerce.infrastructure.Repositories.ShopCartRepository;
import com.spring.Ecommerce.infrastructure.mapper.ShopCartMapper;
import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllProductsOnShopCartImp implements GetAllProductsOnShopCartGateway {

    private final ShopCartMapper shopCartMapper;
    private final ShopCartRepository shopCartRepository;

    @Autowired
    public GetAllProductsOnShopCartImp(ShopCartMapper shopCartMapper, ShopCartRepository shopCartRepository) {
        this.shopCartMapper = shopCartMapper;
        this.shopCartRepository = shopCartRepository;
    }


    @Override
    public List<ShopCart> execute() {
        List<ShopCartEntity> shopCarts = this.shopCartRepository.findAll();
        return shopCarts.stream().map(shopCartMapper::mapToDomainShopCart).collect(Collectors.toList());
    }
}
