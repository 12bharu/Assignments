package com.valtech.account.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	public static final String SAVINGS="SB";
	public static final String CURRENT="CA";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    private String accountType;
    private double balance;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
    private boolean active;
    public Account(String accountType, double balance) {
        super();
        this.accountType = accountType;
        this.balance = balance;
        this.creationTime = LocalDateTime.now();
		this.lastUpdateTime = LocalDateTime.now();
		this.active = active;
       
    }
    
    
    
    
    
    public Account(String accountType, double balance, LocalDateTime creationTime, LocalDateTime lastUpdateTime,
			boolean active) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.creationTime = creationTime;
		this.lastUpdateTime = lastUpdateTime;
		this.active = active;
	}





	public Account(long id, String accountType, double balance, LocalDateTime creationTime, LocalDateTime lastUpdateTime,
            boolean active) {
        super();
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
        this.active = active;
    }






    public Account() {
        super();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String toString() {
        return "Account [id=" + id + ", accountType=" + accountType + ", balance=" + balance + ", creationTime="
                + creationTime + ", lastUpdateTime=" + lastUpdateTime + ", active=" + active + "]";
    }

}
