package com.valtech.account.service;

import java.util.List;

import com.valtech.account.entity.Account;

public interface AccountService {

	Account createAccount(Account acc);

	Account updateAccount(Account acc);

	Account getAccount(long id);

	List<Account> getAllAccount();

	Account createSavingAccount(double balance);

	Account createCurrentAccount(double balance);

}