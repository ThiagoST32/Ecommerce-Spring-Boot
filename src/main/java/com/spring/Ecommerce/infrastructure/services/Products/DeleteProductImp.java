package com.spring.Ecommerce.infrastructure.services.Products;

import com.spring.Ecommerce.core.entities.User;
import com.spring.Ecommerce.core.enums.TypeUser;
import com.spring.Ecommerce.core.gateway.ProductsGateway.DeleteProductGateway;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteProductImp implements DeleteProductGateway {

    private final ProductRepository productRepository;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public DeleteProductImp(ProductRepository productRepository, UserEntityRepository userEntityRepository) {
        this.productRepository = productRepository;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public String execute(Long id, String userName) {
        if (!this.productRepository.existsById(id)) throw new RuntimeException(); //New HandlerException
        UsersEntity whoRequested = this.userEntityRepository.findByName(userName);
        if (whoRequested.getTypeUser() != TypeUser.ADMIN) throw new RuntimeException(); //New HandlerException
        return null;
    }
}
