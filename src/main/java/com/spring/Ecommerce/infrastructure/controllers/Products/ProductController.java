package com.spring.Ecommerce.infrastructure.controllers.Products;

import com.spring.Ecommerce.core.entities.Products;
import com.spring.Ecommerce.infrastructure.dto.ProductDTO;
import com.spring.Ecommerce.infrastructure.mapper.ProductMapper;
import com.spring.Ecommerce.infrastructure.services.Products.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap1/v1/users")
public class ProductController {
    private final GetAllProductsImp getAllProductsImp;
    private final GetProductByNameImp getProductByNameImp;
    private final GetProductByLowestPriceImp getProductByLowestPriceImp;
    private final GetProductByHighestPriceImp getProductByHighestPriceImp;
    private final GetProductByTypeImp getProductByType;
    private final ProductCreateImp productCreateImp;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(GetAllProductsImp getAllProductsImp, GetProductByNameImp getProductByNameImp, GetProductByLowestPriceImp getProductByLowestPriceImp, GetProductByHighestPriceImp getProductByHighestPriceImp, GetProductByTypeImp getProductByType, ProductCreateImp productCreateImp, ProductMapper productMapper) {
        this.getAllProductsImp = getAllProductsImp;
        this.getProductByNameImp = getProductByNameImp;
        this.getProductByLowestPriceImp = getProductByLowestPriceImp;
        this.getProductByHighestPriceImp = getProductByHighestPriceImp;
        this.getProductByType = getProductByType;
        this.productCreateImp = productCreateImp;
        this.productMapper = productMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@RequestBody ProductDTO productDTO) {
        var product = this.productMapper.mapToProductEntity(productDTO);
        Products createdProduct = this.productCreateImp.execute(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/find/byName/{name}")
    public ResponseEntity<List<Products>> getProductByName(@PathVariable String name){
        return new ResponseEntity<>(this.getProductByNameImp.execute(name), HttpStatus.FOUND);
    }

    @GetMapping("/find/byType/{type}")
    public ResponseEntity<List<Products>> getProductByType(@PathVariable String type){
        return new ResponseEntity<>(this.getProductByType.execute(type), HttpStatus.FOUND);
    }

    @GetMapping("/find/byHighestPrice")
    public ResponseEntity<List<Products>> getProductsByHighestPrice(){
        return new ResponseEntity<>(this.getProductByHighestPriceImp.execute(), HttpStatus.FOUND);
    }

    @GetMapping("/find/byLowestPrice")
    public ResponseEntity<List<Products>> getProductsByLowestPrice(){
        return new ResponseEntity<>(this.getProductByLowestPriceImp.execute(), HttpStatus.FOUND);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Products>> getAllProducts(){
        return new ResponseEntity<>(this.getAllProductsImp.execute(), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{userName}/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id, String userName){
        var teste = this.deleteProductById(id, userName);
        return new ResponseEntity<>(teste.getBody(), HttpStatus.ACCEPTED);
    }
}
