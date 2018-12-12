package com.alfred.codingchallenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private Timestamp timestamp;
    private CurrencyType currencyType;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private TransactionType transactionType;
    private String description;

    public Transaction()
    {
        super();
    }

    public Transaction(Long sourceAccountId, Long destinationAccountId, Timestamp timestamp, CurrencyType currencyType, BigDecimal creditAmount, BigDecimal debitAmount, TransactionType transactionType, String description)
    {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.timestamp = timestamp;
        this.currencyType = currencyType;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.transactionType = transactionType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
