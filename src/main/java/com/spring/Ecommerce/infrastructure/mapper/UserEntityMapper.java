package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.infrastructure.dto.UpdateUserDTO;
import com.spring.Ecommerce.infrastructure.dto.UsersEntityDTO;
import com.spring.Ecommerce.infrastructure.persistence.UserCardEntity;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    private final UserCardMapper cardMapper;

    public UserEntityMapper(UserCardMapper cardMapper){
        this.cardMapper = cardMapper;
    }

    public User usersEntity(UsersEntityDTO usersEntityDTO){
        return new User(
                usersEntityDTO.name(),
                usersEntityDTO.document(),
                usersEntityDTO.email(),
                usersEntityDTO.phone(),
                usersEntityDTO.typeUser(),
                usersEntityDTO.userCard()
        );
    }

    public User mapUserToUpdatedUserDomain(UpdateUserDTO updateUserDTO){
        return new User(
                updateUserDTO.name(),
                updateUserDTO.email(),
                updateUserDTO.phone()
        );
    }

    public UsersEntity mapToPersistenceUser(User domainUser, UserCardEntity userCard){
        return new UsersEntity(
                domainUser.getName(),
                domainUser.getDocument(),
                domainUser.getEmail(),
                domainUser.getPhone(),
                domainUser.getTypeUser(),
                userCard
        );
    }

   public UsersEntity mapToPersistenceUser(User domainUser){
        return new UsersEntity(
                domainUser.getName(),
                domainUser.getDocument(),
                domainUser.getEmail(),
                domainUser.getPhone(),
                domainUser.getTypeUser()
        );
    }

    public UsersEntity mapToPersistenceUpdateUser(User domainUser){
        return new UsersEntity(
                domainUser.getName(),
                domainUser.getEmail(),
                domainUser.getPhone()
        );
    }

    public User mapToDomainsUser(UsersEntity persistenceUser) {
        return new User(
                persistenceUser.getId_user(),
                persistenceUser.getName(),
                persistenceUser.getDocument(),
                persistenceUser.getEmail(),
                persistenceUser.getPhone(),
                persistenceUser.getTypeUser(),
                this.cardMapper.mapToDomainsUserCard(persistenceUser.getUserCard())
        );
    }
    public User mapToDomainsUsert(UsersEntity persistenceUser) {
        return new User(
                persistenceUser.getId_user(),
                persistenceUser.getName(),
                persistenceUser.getDocument(),
                persistenceUser.getEmail(),
                persistenceUser.getPhone(),
                persistenceUser.getTypeUser()
        );
    }
}
