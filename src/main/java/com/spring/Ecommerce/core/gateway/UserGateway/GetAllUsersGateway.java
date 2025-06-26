package com.spring.Ecommerce.core.gateway.UserGateway;

import com.spring.Ecommerce.core.entities.User;

import java.util.List;

public interface GetAllUsersGateway {
    List<User> execute();
}
