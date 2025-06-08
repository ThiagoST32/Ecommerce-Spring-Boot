package com.spring.Ecommerce.infrastructure.mapper;

import com.spring.Ecommerce.infrastructure.dto.UserCardDTO;
import com.spring.Ecommerce.infrastructure.persistence.UserCard;
import org.springframework.stereotype.Component;

@Component
public class UserCardMapper {
    public UserCard userCard(UserCardDTO userCardDTO){
        UserCard userCard = new UserCard();
        userCard.setCardNumber(userCardDTO.cardNumber());
        userCard.setPassword(userCardDTO.password());
        userCard.setSecurityCode(userCardDTO.securityCode());
        userCard.setExpirationDate(userCardDTO.expirationDate());
        return userCard;
    }
}
