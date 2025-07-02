package com.spring.Ecommerce.core.useCases.Users;

import com.spring.Ecommerce.core.entities.User;

public interface UserUpdateUseCase {
    User execute(User userUpdated, long id);
}
