package com.alfred.codingchallenge.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	private Long primaryOwnerId;
	private Integer number;
	private String name;
	@Enumerated(EnumType.ORDINAL)
	private AccountType type;
	private Date lastUpdatedBalance;
	private CurrencyType currency;
	private BigDecimal balance;
//	@ManyToOne()
//	private Person primaryOwner;

	public Account()
	{
		super();
	}

	public Account(Long primaryOwnerId, Integer number, String name, AccountType type, Date lastUpdatedBalance, CurrencyType currency, BigDecimal balance){
		this.primaryOwnerId = primaryOwnerId;
		this.number = number;
		this.name = name;
		this.type = type;
		this.lastUpdatedBalance = lastUpdatedBalance;
		this.currency = currency;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public AccountType getType() {
		return type;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public Date getLastUpdatedBalance() {
		return lastUpdatedBalance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}

	public void setLastUpdatedBalance(Date lastUpdatedBalance) {
		this.lastUpdatedBalance = lastUpdatedBalance;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Long getPrimaryOwnerId() {
		return primaryOwnerId;
	}

	public void setPrimaryOwnerId(Long primaryOwnerId) {
		this.primaryOwnerId = primaryOwnerId;
	}

//	public Person getPrimaryOwner() {
//		return primaryOwner;
//	}
//
//	public void setPrimaryOwner(Person primaryOwner) {
//		this.primaryOwner = primaryOwner;
//	}
}
