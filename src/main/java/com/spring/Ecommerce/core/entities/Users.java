package com.spring.Ecommerce.core.entities;

import com.spring.Ecommerce.core.enums.typeUser;

public record Users(Long id_users,
                    String name,
                    String document,
                    String email,
                    String phone,
                    typeUser typeUser,
                    Payments payments) {
}
