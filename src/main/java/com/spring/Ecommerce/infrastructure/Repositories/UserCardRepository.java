package com.spring.Ecommerce.infrastructure.Repositories;

import com.spring.Ecommerce.infrastructure.persistence.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCardRepository extends JpaRepository<UserCard, Long> {
}
