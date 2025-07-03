package com.spring.Ecommerce.core.useCases.Products;

import com.spring.Ecommerce.core.entities.Products;

import java.util.List;

public interface GetAllProductsUseCase {
    List<Products> execute();
}
