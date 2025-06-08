package com.spring.Ecommerce.core.entities;

import com.spring.Ecommerce.core.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record UserPurchases(Long id_userPurchases,
                            BigDecimal amount,
                            String paymentMethod,
                            PaymentMethod paymentStatus,
                            List<ShopCart> shopCarts,
                            UserCard userCard) {
}
