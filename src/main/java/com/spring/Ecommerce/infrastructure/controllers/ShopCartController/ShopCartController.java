package com.spring.Ecommerce.infrastructure.controllers.ShopCartController;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.core.entities.ShopCart;
import com.spring.Ecommerce.infrastructure.Repositories.ProductRepository;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.persistence.ProductEntity;
import com.spring.Ecommerce.infrastructure.services.ShopCart.AddProductOnShopCartImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ap1/v1/shopCart")
public class ShopCartController {

    private final AddProductOnShopCartImp addProductOnShopCartImp;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ShopCartController(AddProductOnShopCartImp addProductOnShopCartImp, ProductRepository productRepository, ProductMapper productMapper) {
        this.addProductOnShopCartImp = addProductOnShopCartImp;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @PostMapping("/{id}")
    private ResponseEntity<ShopCart>addNewProductOnCart(@RequestParam Long id){
        Optional<ProductEntity> test = this.productRepository.findById(id);
        if (test.isEmpty()){
            return null;
        }
        var test02 = this.productMapper.mapToDomainProductTest(test);
        return new ResponseEntity<>(this.addProductOnShopCartImp.execute(test02), HttpStatus.ACCEPTED);
    }
}
