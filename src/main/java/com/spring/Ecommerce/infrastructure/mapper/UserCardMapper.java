package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.core.entities.UserCard;
import com.spring.Ecommerce.infrastructure.dto.UserCardDTO;
import com.spring.Ecommerce.infrastructure.persistence.UserCardEntity;
import org.springframework.stereotype.Component;

@Component
public class UserCardMapper {
    public UserCardEntity userCard(UserCardDTO userCardDTO){
        UserCardEntity userCard = new UserCardEntity();
        userCard.setCardNumber(userCardDTO.cardNumber());
        userCard.setSecurityCode(userCardDTO.securityCode());
        userCard.setExpirationDate(userCardDTO.expirationDate());
        return userCard;
    }

    public UserCard mapToDomainsUserCard(UserCardEntity cardEntity){
        return new UserCard(
                cardEntity.getId_card(),
                cardEntity.getCardNumber(),
                cardEntity.getSecurityCode(),
                cardEntity.getCardHolderName(),
                cardEntity.getExpirationDate()
        );
    }

    public UserCardEntity mapToPersistenceUserCard(UserCard userCard){
        return new UserCardEntity(
                userCard.getCardNumber(),
                userCard.getSecurityCode(),
                userCard.getCardHolderName(),
                userCard.getExpirationDate()
        );
    }
}
