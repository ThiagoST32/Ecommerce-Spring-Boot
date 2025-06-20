package com.spring.Ecommerce.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user_card")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_card;
    private int cardNumber;
    private int password;
    private int securityCode;
    private String cardHolderName;
    private String expirationDate;

    //@OneToOne
    //@JoinColumn(name = "id_user_card", referencedColumnName = "id_user")
    //private Users user;
}
