package com.joga10.api_joga10.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment_methods")
public class PaymentMethod {
    @Id
    private String id;
    private String userId;
    private String type; // PIX, CREDIT_CARD
    private String pixKey; // se for PIX
    private String cardNumber; // se for cartão
    private String cardHolder;
    private String cardExpiration;
    private String cardCvv;

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getPixKey() { return pixKey; }
    public void setPixKey(String pixKey) { this.pixKey = pixKey; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getCardHolder() { return cardHolder; }
    public void setCardHolder(String cardHolder) { this.cardHolder = cardHolder; }
    public String getCardExpiration() { return cardExpiration; }
    public void setCardExpiration(String cardExpiration) { this.cardExpiration = cardExpiration; }
    public String getCardCvv() { return cardCvv; }
    public void setCardCvv(String cardCvv) { this.cardCvv = cardCvv; }
}
