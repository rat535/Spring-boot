package com.project.Banking.Mapper;

import com.project.Banking.Dto.AccountDto;
import com.project.Banking.model.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto)
	{
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountholderName(),
				accountDto.getBalance()                                        		
	    );
		return account;
				
	}
	
	public static AccountDto mapToAccountDto(Account account)
	{
		AccountDto accountdto = new AccountDto(
		
			account.getId(),
			account.getAccountholdername(),
			account.getBalance()
				
	      );
		return accountdto;
	}
}