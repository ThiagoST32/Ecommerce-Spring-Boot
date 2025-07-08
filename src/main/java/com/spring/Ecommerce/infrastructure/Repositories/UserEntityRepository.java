package com.spring.Ecommerce.infrastructure.Repositories;

import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByDocument(String document);
    UsersEntity findByEmail(String email);
    UsersEntity findById(long id);
    UsersEntity findByName(String userName);
    boolean existsByName(String userName);
}
