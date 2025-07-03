package com.spring.Ecommerce.infrastructure.services.Products;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.gateway.ProductsGateway.GetProductByHighestPriceGateway;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class GetProductByHighestPriceImp implements GetProductByHighestPriceGateway {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public GetProductByHighestPriceImp(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> execute() {
        List<ProductEntity> productsByHighestPrice = this.productRepository.findByHighestProductValue();
        return productsByHighestPrice.stream().map(productMapper::mapToDomainProduct).collect(Collectors.toList());
    }
}
