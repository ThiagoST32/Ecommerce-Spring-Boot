package com.spring.Ecommerce.infrastructure.services.User;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.gateway.UserGateway.GetAllUsersGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUsersImp implements GetAllUsersGateway {

    private final UserEntityMapper userEntityMapper;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public GetAllUsersImp(UserEntityMapper userEntityMapper, UserEntityRepository userEntityRepository) {
        this.userEntityMapper = userEntityMapper;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public List<User> execute() {
        List<UsersEntity> users = this.userEntityRepository.findAll();
        return users.stream().map(userEntityMapper::mapToDomainsUser).collect(Collectors.toList());
    }
}
