package com.spring.Ecommerce.core.entities;

import com.spring.Ecommerce.core.enums.TypeUser;

public record Users(Long id_users,
                    String name,
                    String document,
                    String email,
                    String phone,
                    TypeUser typeUser,
                    UserCard userCard) {
}
