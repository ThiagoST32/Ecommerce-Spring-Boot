package com.spring.Ecommerce.core.useCases.Users;

import com.spring.Ecommerce.core.entities.User;

public interface FindUserByDocumentUseCase {
    User execute(String document);
}
