package com.spring.Ecommerce.infrastructure.persistence;

import com.spring.Ecommerce.core.enums.TypeUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String name;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_card", referencedColumnName = "id_card")
    private UserCardEntity userCard;

    public UsersEntity(String name, String document, String email, String phone, TypeUser typeUser, UserCardEntity userCard) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.typeUser = typeUser;
        this.userCard = userCard;
    }

    public UsersEntity(String name, String document, String email, String phone, TypeUser typeUser) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.typeUser = typeUser;
    }

    public UsersEntity(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
