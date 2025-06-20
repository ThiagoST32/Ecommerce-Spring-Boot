package com.spring.Ecommerce.core.gateway.ProductsGateway;

import com.spring.Ecommerce.core.entities.Products;

public interface UpdateProductByIdGateway {
    Products execute(int id, Products productsUpdated);
}
