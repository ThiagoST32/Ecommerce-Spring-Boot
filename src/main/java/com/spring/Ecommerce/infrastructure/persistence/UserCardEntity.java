package com.spring.Ecommerce.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_users_card")
public class UserCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_card;
    @Column(unique = true)
    private int cardNumber;
    private int securityCode;
    private String cardHolderName;
    private String expirationDate;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userCard")
    private UsersEntity users;

    public UserCardEntity (int cardNumber,int securityCode, String cardHolderName, String expirationDate){
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }
}
