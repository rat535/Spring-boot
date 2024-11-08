package com.project.Banking.service;

import java.util.List;

import com.project.Banking.Dto.AccountDto;


public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto deposit(Long id, double ammount);
	AccountDto withdraw(Long id, double ammount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(Long id);
}
