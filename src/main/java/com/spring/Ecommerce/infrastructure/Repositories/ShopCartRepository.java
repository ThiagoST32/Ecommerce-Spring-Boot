package com.spring.Ecommerce.infrastructure.Repositories;

import com.spring.Ecommerce.infrastructure.persistence.ShopCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCartRepository extends JpaRepository<ShopCartEntity, Long> {
}
