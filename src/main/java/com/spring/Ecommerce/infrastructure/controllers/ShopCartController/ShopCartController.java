package com.spring.Ecommerce.infrastructure.controllers.ShopCartController;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.Repositories.UserEntityRepository;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.mapper.UserEntityMapper;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import com.spring.Ecommerce.infrastructure.persistence.UsersEntity;
import com.spring.Ecommerce.infrastructure.services.ShopCart.AddProductOnShopCartImp;
import com.spring.Ecommerce.infrastructure.services.ShopCart.GetAllProductsOnShopCartImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ap1/v1/shopCart")
public class ShopCartController {

    private final AddProductOnShopCartImp addProductOnShopCartImp;
    private final GetAllProductsOnShopCartImp getAllProductsOnShopCartImp;
    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ShopCartController(AddProductOnShopCartImp addProductOnShopCartImp, GetAllProductsOnShopCartImp getAllProductsOnShopCartImp, UserEntityRepository userEntityRepository, UserEntityMapper userEntityMapper, ProductRepository productRepository, ProductMapper productMapper) {
        this.addProductOnShopCartImp = addProductOnShopCartImp;
        this.getAllProductsOnShopCartImp = getAllProductsOnShopCartImp;
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @PostMapping("/{id}/{name_user}")
    private ResponseEntity<ShopCart> addNewProductOnCart(@PathVariable Long id, @PathVariable String name_user) {
        ProductEntity test = this.productRepository.findProductById(id);

        UsersEntity cardOwnerEntity = this.userEntityRepository.findByName(name_user);

        var cardOwner = this.userEntityMapper.mapToDomainsUsert(cardOwnerEntity);

        var test02 = this.productMapper.mapToDomainProductTest(test);
        return new ResponseEntity<>(this.addProductOnShopCartImp.execute(test02, cardOwner), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    private ResponseEntity<List<ShopCart>> getAllShopCarts() {
        return new ResponseEntity<>(this.getAllProductsOnShopCartImp.execute(), HttpStatus.FOUND);
    }
}
