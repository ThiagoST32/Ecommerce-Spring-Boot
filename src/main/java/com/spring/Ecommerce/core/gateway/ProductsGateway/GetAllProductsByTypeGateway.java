package com.spring.Ecommerce.core.gateway.ProductsGateway;

import com.spring.Ecommerce.core.entities.Products;

import java.util.List;

public interface GetAllProductsByTypeGateway {
    List<Products> execute(String type);
}
