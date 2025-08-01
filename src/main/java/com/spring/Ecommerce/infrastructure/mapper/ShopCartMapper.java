package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.infrastructure.dto.ShopCartDTO;
import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopCartMapper {

    private final ProductMapper productMapper;
    private final UserEntityMapper userEntityMapper;

    @Autowired
    public ShopCartMapper(ProductMapper productMapper, UserEntityMapper userEntityMapper) {
        this.productMapper = productMapper;
        this.userEntityMapper = userEntityMapper;
    }

    public ShopCart shopCartToEntity(ShopCartDTO shopCartDTO) {
        return new ShopCart(
                shopCartDTO.productsList(),
                shopCartDTO.totalValue(),
                this.userEntityMapper.mapToDomainsUser(shopCartDTO.user())
        );
    }

//    public ShopCartEntity mapToPersistenceShopCart(ShopCart shopCart) {
//        return new ShopCartEntity(
//                this.productMapper.mapToPersistenceProductList(shopCart),
//                shopCart.getTotalPrice(),
//                shopCart.getId_user()
//        );
//    }

    public ShopCart mapToDomainShopCart(ShopCartEntity shopCartEntity) {
        return new ShopCart(
                shopCartEntity.getId(),
                this.productMapper.mapToDomainProductList(shopCartEntity),
                shopCartEntity.getTotalValue(),
                this.userEntityMapper.mapToDomainsUser(shopCartEntity.getUsersEntity())
        );
    }
}
