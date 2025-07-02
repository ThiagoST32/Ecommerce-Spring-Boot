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

    //Need valid data if is empty / null
    @Override
    public User execute(User userUpdatedReceive, long id) {
        if (!this.repository.existsById(id)) return null;
        UsersEntity updatedUser = this.repository.findById(id);
        updatedUser.setName(userUpdatedReceive.getName());
        updatedUser.setEmail(userUpdatedReceive.getEmail());
        updatedUser.setPhone(userUpdatedReceive.getPhone());
        this.repository.save(updatedUser);
        return this.mapper.mapToDomainsUser(updatedUser);
    }
}
