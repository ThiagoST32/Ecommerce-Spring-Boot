package com.spring.Ecommerce.infrastructure.services;

import com.spring.Ecommerce.core.gateway.UserGateway.UserDeleteGateway;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteImp implements UserDeleteGateway {
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserDeleteImp(UserEntityRepository repository){
        this.userEntityRepository = repository;
    }

    @Override
    @Transactional
    public void execute(Long id) {
        System.out.println("Id recebido -> " + id);
        if (!this.userEntityRepository.existsById(id)){
            System.out.println("Invalid Id!");
            //throw new UserNotFoundException;
        }
        this.userEntityRepository.deleteById(id);
    }
}
