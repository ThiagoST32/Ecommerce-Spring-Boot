package com.spring.Ecommerce.core.gateway.ProductsGateway;

import com.spring.Ecommerce.core.entities.Products;

public interface GetProductByNameGateway {
    Products execute(String name);
}
