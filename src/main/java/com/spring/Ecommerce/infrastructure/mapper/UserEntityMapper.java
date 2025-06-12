package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.infrastructure.dto.UsersEntityDTO;
import com.spring.Ecommerce.infrastructure.persistence.Users;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User usersEntity(UsersEntityDTO usersEntityDTO){
        return new User(
                usersEntityDTO.name(),
                usersEntityDTO.document(),
                usersEntityDTO.email(),
                usersEntityDTO.phone(),
                usersEntityDTO.typeUser()
                //usersEntityDTO.userCard()
        );
    }

    public Users mapToPersistenceUser(User domainUser){
        Users persistenceUser = new Users();
        persistenceUser.setName(domainUser.getName());
        persistenceUser.setDocument(domainUser.getDocument());
        persistenceUser.setEmail(domainUser.getEmail());
        persistenceUser.setPhone(domainUser.getPhone());
        persistenceUser.setTypeUser(domainUser.getTypeUser());
        //persistenceUser.setUserCard(domainUser.getUserCard());
        return persistenceUser;
    }

    public User mapToDomainsUser(Users persistenceUser) {
        return new User(
                persistenceUser.getName(),
                persistenceUser.getDocument(),
                persistenceUser.getEmail(),
                persistenceUser.getPhone(),
                persistenceUser.getTypeUser()
                //persistenceUser.getUserCard()
        );
    }
}
