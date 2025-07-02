package com.spring.Ecommerce.infrastructure.services.User;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.UserGateway.UserUpdateGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateImp implements UserUpdateGateway {
    private final UserEntityRepository repository;
    private final UserEntityMapper mapper;

    @Autowired
    public UserUpdateImp(UserEntityRepository repository, UserEntityMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public User execute(User userUpdatedReceive) {
        UsersEntity updatedUser = this.mapper.mapToPersistenceUser(userUpdatedReceive);
        this.repository.saveAndFlush(updatedUser);
        return this.mapper.mapToDomainsUser(updatedUser);
    }
}
