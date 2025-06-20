package com.spring.Ecommerce.core.gateway.UserGateway;

import com.spring.Ecommerce.core.entities.User;

public interface FindUserByDocumentGateway {
    User execute(String document);
}
