package com.example.uppgift_backend.backend_uppgift1.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transactions {
    @Id
    private String id;
    private String usersId;
    private String plantsId;
    private String transactionType;
    private Double amount;  //price, amountPlant, transactionAmount
    private String transactionStatus;
    private String tradeUserId;
    private String tradePlantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getPlantsId() {
        return plantsId;
    }

    public void setPlantsId(String plantsId) {
        this.plantsId = plantsId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String status) {
        this.transactionStatus = status;
    }

    public String getTradeUserId() {
        return tradeUserId;
    }

    public void setTradeUserId(String tradeUserId) {
        this.tradeUserId = tradeUserId;
    }

    public String getTradePlantId() {
        return tradePlantId;
    }

    public void setTradePlantId(String tradePlantId) {
        this.tradePlantId = tradePlantId;
    }

    public Transactions() {
    }
}
