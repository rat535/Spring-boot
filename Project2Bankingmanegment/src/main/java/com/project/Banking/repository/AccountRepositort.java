package com.project.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Banking.model.Account;

public interface AccountRepositort extends JpaRepository<Account,Long> {
	

}
