package com.spring.Ecommerce.core.useCases.Users;

import com.spring.Ecommerce.infrastructure.persistence.UserCard;

public interface AddNewUser {
    void execute(String name, String document, String email, String phone, String typeUser, UserCard userCard);
}
