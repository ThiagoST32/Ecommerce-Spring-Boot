 package com.spring.Ecommerce.core.gateway.UserGateway;

import com.spring.Ecommerce.core.entities.User;

public interface UserCreateGateway{
    User execute(User users);
}
