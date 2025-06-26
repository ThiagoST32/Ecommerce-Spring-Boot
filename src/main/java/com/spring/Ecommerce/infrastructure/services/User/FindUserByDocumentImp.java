package com.spring.Ecommerce.infrastructure.services.User;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.UserGateway.FindUserByDocumentGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByDocumentImp implements FindUserByDocumentGateway {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;

    @Autowired
    public FindUserByDocumentImp(UserEntityRepository userEntityRepository, UserEntityMapper userEntityMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User execute(String document) {
        Users userGet = this.userEntityRepository.findByDocument(document);
        return this.userEntityMapper.mapToDomainsUser(userGet);
    }
}
