package com.project.Banking.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

	private Long id;
	private String accountholderName;
	private double balance;
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(Long id, String accountholderName, double balance) {
		super();
		this.id = id;
		this.accountholderName = accountholderName;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountholderName() {
		return accountholderName;
	}
	public void setAccountholderName(String accountholderName) {
		this.accountholderName = accountholderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
}
