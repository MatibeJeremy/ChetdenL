package com.jeremyalloys.boot.lendint.interview_prep.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

// This is our database Object. This class will help us play around with
// data. The fields in the database need SETTERS and GETTERS
// TODO: Implement setters and getters for the class - This will help with queries!

@Entity
@Table(name="TRANSACTION")
public class Transaction {
    @Id
    @Column(name="TRANSACTION_ID")
    @GeneratedValue
    private long id;
    @Column(name="RECEIVER_ACC")
    private String receiver;
    @Column(name="SENDER_ACC")
    private String sender;
    @Column(name="AMOUNT")
    private double amount;
    @Column(name="MEDIUM")
    private String medium;

    public Transaction() {
        super();
    }

    public Transaction(long id, String receiver, String sender, double amount, String medium) {
        super();
        this.id = id;
        this.receiver = receiver;
        this.sender = sender;
        this.amount = amount;
        this.medium = medium;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String name) {
        this.receiver = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String name) {
        this.sender = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
