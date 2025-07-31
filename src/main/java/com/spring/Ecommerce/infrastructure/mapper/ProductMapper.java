package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.infrastructure.dto.ProductDTO;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Products mapToProductEntity(ProductDTO productDTO) {
        return new Products(
                productDTO.productName(),
                productDTO.descriptionProduct(),
                productDTO.quantity(),
                productDTO.productValue(),
                productDTO.typeProduct()
        );
    }

    public ProductEntity mapToPersistenceProduct(Products products) {
        return new ProductEntity(
                products.getNameProduct(),
                products.getDescriptionProduct(),
                products.getQuantityProduct(),
                products.getProductValue(),
                products.getTypeProduct()
        );
    }

    public Products mapToDomainProduct(ProductEntity productEntity) {
        return new Products(
                productEntity.getId(),
                productEntity.getProductName(),
                productEntity.getDescriptionProduct(),
                productEntity.getQuantityProduct(),
                productEntity.getProductValue(),
                productEntity.getTypeProduct()
        );
    }

    public Products mapToDomainProductTest(ProductEntity productEntity) {
        return new Products(
                productEntity.getId(),
                productEntity.getProductName(),
                productEntity.getDescriptionProduct(),
                productEntity.getQuantityProduct(),
                productEntity.getProductValue(),
                productEntity.getTypeProduct()
        );
    }

        public List<Products> mapToDomainProductList(ShopCartEntity shopCartList) {
        if (shopCartList == null || shopCartList.getProductsList() == null) {
            return Collections.emptyList();
        }
        return shopCartList.getProductsList().stream().map(this::mapToDomainProduct).collect(Collectors.toList());
    }

    public List<ProductEntity> mapToPersistenceProductList(Products products) {
        if (products == null) {
            return Collections.emptyList();
        }
        List<ProductEntity> teste = new ArrayList<>();
        teste.add(this.mapToPersistenceProduct(products));
//        teste.stream().map(this::mapToDomainProduct).forEachOrdered(Products.class);
        return teste;
    }

}
