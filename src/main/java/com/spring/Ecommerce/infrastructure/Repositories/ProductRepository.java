package com.spring.Ecommerce.infrastructure.Repositories;

import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    //List<ProductEntity> findByTypeProduct(String type);
    List<ProductEntity> findByProductName(String name);
    @Query(value = "SELECT * FROM tb_products ORDER ASC BY productValue;", nativeQuery = true)
    List<ProductEntity> findByHighestProductValue();

    @Query(value = "SELECT * FROM tb_product ORDER DESC BY productValue", nativeQuery = true)
    List<ProductEntity> findByLowestProductValue();
}
