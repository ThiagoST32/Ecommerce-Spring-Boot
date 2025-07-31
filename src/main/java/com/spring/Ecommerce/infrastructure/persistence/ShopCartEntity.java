package com.spring.Ecommerce.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_shopCart")
public class ShopCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal totalValue;

    @OneToMany
    private List<ProductEntity> productsList;

    @Column(unique = true)
    private Long id_user;

    public ShopCartEntity(List<ProductEntity> products, BigDecimal totalPrice, Long id_user) {
        this.productsList = products;
        this.totalValue = totalPrice;
        this.id_user = id_user;
    }
}
