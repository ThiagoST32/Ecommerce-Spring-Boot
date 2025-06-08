package com.spring.Ecommerce.infrastructure.dto;

public record UserCardDTO(int cardNumber, int password, int securityCode, String expirationDate) {
}
