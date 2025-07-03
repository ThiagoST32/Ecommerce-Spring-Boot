package com.spring.Ecommerce.infrastructure.services.Products;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.gateway.ProductsGateway.GetProductByNameGateway;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class GetProductByNameImp implements GetProductByNameGateway {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public GetProductByNameImp(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> execute(String name) {
        List<ProductEntity> products = this.productRepository.findByProductName(name);
        return products.stream().map(productMapper::mapToDomainProduct).collect(Collectors.toList());
    }
}
