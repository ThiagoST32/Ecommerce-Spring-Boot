package com.spring.Ecommerce.core.entities;

import java.util.Date;

public record UserCard(
        Long id_card,
        String cardNumber,
        String password,
        int securityCode,
        String cardHolderName,
        Date expirationDate
) {}
