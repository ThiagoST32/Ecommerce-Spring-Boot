package com.spring.Ecommerce.core.useCases.Products;

import com.spring.Ecommerce.core.entities.Products;

public interface GetProductByNameUseCase {
    Products execute(String nameProduct);
}
