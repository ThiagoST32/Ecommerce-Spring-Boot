package com.spring.Ecommerce.core.entities;

import java.util.Date;
import java.util.Objects;

public final class UserCard {
    Long id_card;
    int cardNumber;
    int securityCode;
    String cardHolderName;
    String expirationDate;

    public UserCard(Long id_card, int cardNumber, int securityCode, String cardHolderName, String expirationDate) {
        this.id_card = id_card;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserCard) obj;
        return Objects.equals(this.id_card, that.id_card) &&
                Objects.equals(this.cardNumber, that.cardNumber) &&
                this.securityCode == that.securityCode &&
                Objects.equals(this.cardHolderName, that.cardHolderName) &&
                Objects.equals(this.expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_card, cardNumber, securityCode, cardHolderName, expirationDate);
    }

    @Override
    public String toString() {
        return "UserCard[" +
                "id_card=" + id_card + ", " +
                "cardNumber=" + cardNumber + ", " +
                "securityCode=" + securityCode + ", " +
                "cardHolderName=" + cardHolderName + ", " +
                "expirationDate=" + expirationDate + ']';
    }
}
