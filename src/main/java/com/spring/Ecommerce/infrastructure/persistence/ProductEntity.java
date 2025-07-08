package com.spring.Ecommerce.infrastructure.persistence;

import com.spring.Ecommerce.core.enums.TypeProduct;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String descriptionProduct;
    private int quantityProduct;
    private BigDecimal productValue;
    private TypeProduct typeProduct;

    public ProductEntity(String productName, String descriptionProduct, int quantityProduct, BigDecimal productValue, TypeProduct typeProduct){
        this.productName = productName;
        this.descriptionProduct = descriptionProduct;
        this.quantityProduct = quantityProduct;
        this.productValue = productValue;
        this.typeProduct = typeProduct;
    }
}

