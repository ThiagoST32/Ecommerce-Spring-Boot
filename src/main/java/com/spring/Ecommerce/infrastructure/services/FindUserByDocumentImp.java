package com.spring.Ecommerce.infrastructure.services;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.UserGateway.FindUserByDocumentGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindUserByDocumentImp implements FindUserByDocumentGateway {

    private final UserEntityRepository userEntityRepository;

    public FindUserByDocumentImp(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User execute(String document) {
        if (!document.contains("@")) throw new RuntimeException("Invalid document format. Document should be an email address.");
        return this.userEntityRepository.findByDocument(document);
    }
}
