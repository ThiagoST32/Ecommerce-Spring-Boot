package com.spring.Ecommerce.core.entities;

public record Users (Long id,
        String name,
        String document,
        String email,
        String phone,
        Payments payments){}
