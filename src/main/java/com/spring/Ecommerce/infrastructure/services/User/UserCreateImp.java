package com.spring.Ecommerce.infrastructure.services.User;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.UserGateway.UserCreateGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.UserCardMapper;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreateImp implements UserCreateGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;
    private final UserCardMapper userCardMapper;

    @Autowired
    public UserCreateImp(UserEntityRepository userEntityRepository, UserEntityMapper userEntityMapper, UserCardMapper userCardMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
        this.userCardMapper = userCardMapper;
    }

    @Override
    public User execute(User domainUser) {
        var userCard = this.userCardMapper.mapToPersistenceUserCard(domainUser.getUserCard());
        UsersEntity persistenceUser = this.userEntityMapper.mapToPersistenceUser(domainUser, userCard);
        UsersEntity savedUser = this.userEntityRepository.save(persistenceUser);
        return this.userEntityMapper.mapToDomainsUser(savedUser);
    }
}
