package com.spring.Ecommerce.core.gateway;

import com.spring.Ecommerce.core.entities.User;

public interface FindUserByDocumentGateway {
    User execute(String document);
}
