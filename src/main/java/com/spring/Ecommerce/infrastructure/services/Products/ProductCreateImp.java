package com.spring.Ecommerce.infrastructure.services.Products;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.gateway.ProductsGateway.AddNewProductGateway;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCreateImp implements AddNewProductGateway {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductCreateImp(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    @Override
    public Products execute(Products products) {
        var product = this.productMapper.mapToPersistenceProduct(products);
        ProductEntity newProduct = this.repository.save(product);
        return this.productMapper.mapToDomainProduct(newProduct);
    }
}
