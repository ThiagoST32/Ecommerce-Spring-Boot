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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String name;
    private String document;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    //@OneToOne
    //@JoinColumn(name = "id_user", referencedColumnName = "id_user_card")
    //private UserCard userCard;
}
