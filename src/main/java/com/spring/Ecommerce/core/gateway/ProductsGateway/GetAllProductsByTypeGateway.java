package com.spring.Ecommerce.core.gateway.ProductsGateway;

import com.spring.Ecommerce.core.entities.Products;

public interface GetAllProductsByTypeGateway {
    Products execute(String type);
}
