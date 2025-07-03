package com.spring.Ecommerce.infrastructure.services.Products;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.gateway.ProductsGateway.GetAllProductsByTypeGateway;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetProductByTypeImp implements GetAllProductsByTypeGateway {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public GetProductByTypeImp(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> execute(String type) {
       // List<ProductEntity> productsByType = this.productRepository.findByTypeProduct(type);
       // return productsByType.stream().map(productMapper::mapToDomainProduct).collect(Collectors.toList());
        return null;
    }
}
