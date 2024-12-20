package com.project.Banking.service.impl;




import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.Banking.Dto.AccountDto;
import com.project.Banking.Mapper.AccountMapper;
import com.project.Banking.model.Account;
import com.project.Banking.repository.AccountRepositort;
import com.project.Banking.service.AccountService;


@Service
public class AccountInpl implements AccountService {

	private AccountRepositort accountRepository;
	
	public AccountInpl(AccountRepositort accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot exists"));
		double total = account.getBalance()+amount;
		account.setBalance(total);
		Account savAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double ammount) {
		Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot exists"));
		if(account.getBalance() < ammount)
		{
			throw new RuntimeException("insufficent balance");
		}
		
		double total = account.getBalance() - ammount;
		account.setBalance(total);
		
		Account savAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
	
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Doesnot exists"));
		accountRepository.deleteById(id);
		
	}

}
