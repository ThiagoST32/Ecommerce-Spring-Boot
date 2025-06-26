package com.spring.Ecommerce.core.useCases.Users;

import com.spring.Ecommerce.core.entities.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> execute();
}
