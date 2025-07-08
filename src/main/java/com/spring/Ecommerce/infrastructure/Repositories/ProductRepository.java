package com.spring.Ecommerce.infrastructure.Repositories;

import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByProductName(String name);
    @Query(value = "SELECT * FROM tb_products ORDER BY product_value DESC;", nativeQuery = true)
    List<ProductEntity> findByHighestProductValue();

    @Query(value = "SELECT * FROM tb_products ORDER BY product_value ASC;", nativeQuery = true)
    List<ProductEntity> findByLowestProductValue();

    @Query(value = "SELECT * FROM tb_products WHERE tb_products.type_product = :type", nativeQuery = true)
    List<ProductEntity>findByTypeProduct(@Param("type") int type);
}
