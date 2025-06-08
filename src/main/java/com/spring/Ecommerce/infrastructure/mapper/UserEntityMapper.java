package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.infrastructure.dto.UsersEntityDTO;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UsersEntity usersEntity(UsersEntityDTO usersEntityDTO){
        UsersEntity userEntity = new UsersEntity();
        userEntity.setName(usersEntityDTO.name());
        userEntity.setDocument(usersEntityDTO.document());
        userEntity.setEmail(usersEntityDTO.email());
        userEntity.setPhone(usersEntityDTO.phone());
        userEntity.setTypeUser(usersEntityDTO.typeUser());
        return userEntity;
    }
}
