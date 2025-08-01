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
@RequestMapping("/ap1/v1/products")
public class ProductController {
    private final GetAllProductsImp getAllProductsImp;
    private final GetProductByNameImp getProductByNameImp;
    private final GetProductByLowestPriceImp getProductByLowestPriceImp;
    private final GetProductByHighestPriceImp getProductByHighestPriceImp;
    private final GetProductByTypeImp getProductByType;
    private final ProductCreateImp productCreateImp;
    private final ProductMapper productMapper;
    private final DeleteProductImp deleteProductImp;

    @Autowired
    public ProductController(GetAllProductsImp getAllProductsImp, GetProductByNameImp getProductByNameImp, GetProductByLowestPriceImp getProductByLowestPriceImp, GetProductByHighestPriceImp getProductByHighestPriceImp, GetProductByTypeImp getProductByType, ProductCreateImp productCreateImp, ProductMapper productMapper, DeleteProductImp deleteProductImp) {
        this.getAllProductsImp = getAllProductsImp;
        this.getProductByNameImp = getProductByNameImp;
        this.getProductByLowestPriceImp = getProductByLowestPriceImp;
        this.getProductByHighestPriceImp = getProductByHighestPriceImp;
        this.getProductByType = getProductByType;
        this.productCreateImp = productCreateImp;
        this.productMapper = productMapper;
        this.deleteProductImp = deleteProductImp;
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@RequestBody ProductDTO productDTO) {
        System.out.println(productDTO);
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

    @DeleteMapping("/delete/{id}/{userName}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id, @PathVariable String userName){
        return new ResponseEntity<>(this.deleteProductImp.execute(id, userName), HttpStatus.ACCEPTED);
    }
}
