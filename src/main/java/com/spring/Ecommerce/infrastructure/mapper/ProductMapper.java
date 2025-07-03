package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.infrastructure.dto.ProductDTO;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;

public class ProductMapper {

    public Products mapToProductEntity(ProductDTO productDTO){
        return new Products(
                productDTO.productName(),
                productDTO.descriptionProduct(),
                productDTO.quantity(),
                productDTO.productValue(),
                productDTO.typeProduct()
        );
    }

    public ProductEntity mapToPersistenceProduct(Products products){
        return new ProductEntity(
                products.nameProduct(),
                products.descriptionProduct(),
                products.quantityProduct(),
                products.productValue(),
                products.typeProduct()
        );
    }

    public Products mapToDomainProduct(ProductEntity productEntity){
        return new Products(
                productEntity.getProductName(),
                productEntity.getDescriptionProduct(),
                productEntity.getQuantityProduct(),
                productEntity.getProductValue(),
                productEntity.getTypeProduct()
        );
    }

}
