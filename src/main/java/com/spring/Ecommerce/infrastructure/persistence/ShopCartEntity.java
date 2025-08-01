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

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UsersEntity usersEntity;

    @Column(nullable = false)
    private Integer quantity;

    public ShopCartEntity(List<ProductEntity> products, BigDecimal totalPrice, UsersEntity user, Integer quantity) {
        this.productsList = products;
        this.totalValue = totalPrice;
        this.usersEntity = user;
        this.quantity = quantity;
    }

    public ShopCartEntity(Long id, List<ProductEntity> products, BigDecimal totalPrice, UsersEntity user, Integer quantity) {
        this.id = id;
        this.productsList = products;
        this.totalValue = totalPrice;
        this.usersEntity = user;
        this.quantity = quantity;
    }
}
