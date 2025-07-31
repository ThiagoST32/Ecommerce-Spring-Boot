package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.infrastructure.dto.ShopCartDTO;
import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ShopCartMapper {

    private final ProductMapper productMapper;

    @Autowired
    public ShopCartMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ShopCart shopCartToEntity(ShopCartDTO shopCartDTO) {
        return new ShopCart(
                shopCartDTO.productsList(),
                shopCartDTO.totalValue(),
                shopCartDTO.id_user()
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
                this.productMapper.mapToDomainProductList(shopCartEntity),
                shopCartEntity.getTotalValue(),
                shopCartEntity.getId_user()
        );
    }
}
