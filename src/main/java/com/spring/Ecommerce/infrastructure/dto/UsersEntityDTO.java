package com.spring.Ecommerce.infrastructure.dto;

import com.spring.Ecommerce.core.entities.UserCard;
import com.spring.Ecommerce.core.enums.TypeUser;

public record UsersEntityDTO(String name,
                             String document,
                             String email,
                             String phone,
                             TypeUser typeUser,
                             UserCard userCard) {
}
