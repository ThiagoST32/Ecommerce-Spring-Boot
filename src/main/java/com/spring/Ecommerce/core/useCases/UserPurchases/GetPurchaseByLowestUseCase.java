package com.spring.Ecommerce.core.useCases.UserPurchases;

import com.spring.Ecommerce.core.entities.UserPurchases;

public interface GetPurchaseByLowestUseCase {
    UserPurchases execute(UserPurchases purchases);
}
