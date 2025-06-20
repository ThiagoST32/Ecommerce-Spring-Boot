package com.spring.Ecommerce.core.entities;

import com.spring.Ecommerce.core.enums.TypeUser;

import java.util.Objects;

public class User {
    Long id_user;
    String name;
    String document;
    String email;
    String phone;
    TypeUser typeUser;
    UserCard userCard;

    public User(String name, String document, String email, String phone, TypeUser typeUser) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.typeUser = typeUser;
    }

    public User() {
    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id_user, user.id_user) && Objects.equals(name, user.name) && Objects.equals(document, user.document) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && typeUser == user.typeUser && Objects.equals(userCard, user.userCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, name, document, email, phone, typeUser, userCard);
    }

    @Override
    public String toString() {
        return "User{" +
                "id_users=" + id_user +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", typeUser=" + typeUser +
                ", userCard=" + userCard +
                '}';
    }
}
