package com.spring.Ecommerce.infrastructure.Repositories;

import com.spring.Ecommerce.infrastructure.persistence.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<Users, Long> {
}
