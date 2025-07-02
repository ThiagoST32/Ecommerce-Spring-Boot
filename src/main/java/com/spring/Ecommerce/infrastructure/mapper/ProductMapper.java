package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.infrastructure.dto.ProductDTO;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;

public class ProductMapper {
    public ProductEntity mapToPersistenceProduct(ProductDTO productDTO){
        return new ProductEntity(
                productDTO.productName(),
                productDTO.descriptionProduct(),
                productDTO.quantity(),
                productDTO.productValue(),
                productDTO.typeProduct()
        );
    }
}
