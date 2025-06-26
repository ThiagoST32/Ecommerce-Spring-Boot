package com.spring.Ecommerce.infrastructure.services.User;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.UserGateway.UserCreateGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreateImp implements UserCreateGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;

    @Autowired
    public UserCreateImp(UserEntityRepository userEntityRepository, UserEntityMapper userEntityMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User execute(User domainUser) {
        Users persistenceUser = this.userEntityMapper.mapToPersistenceUser(domainUser);
        Users savedUser = this.userEntityRepository.save(persistenceUser);
        return this.userEntityMapper.mapToDomainsUser(savedUser);
    }
}
