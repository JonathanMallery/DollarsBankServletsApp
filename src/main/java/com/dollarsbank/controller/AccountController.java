package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class AccountController {

		private ArrayList<Account> accounts;

		
		
		public AccountController() {
			super();
			this.accounts = new ArrayList<Account>();
			addAccount(new Account(1,2,25_547_118.36)); // Drew Brees - DB
			addAccount(new Account(2,4,8.50));			// Ed Edd - Eddie
			addAccount(new Account(3,1,450.00));		//Jonathan Mallery - jmall
			addAccount(new Account(4,3,1_999.36));		//You Me - meyou
		}
		
		public AccountController(ArrayList<Account> accounts) {
			this.accounts = accounts;
		}

		public ArrayList<Account> getAccounts() {
			return accounts;
		}
		
		public boolean addAccount(Account account) {
			this.accounts.add(account);
			return true;
		}
		
		public Account findAccountByAccountId(int id) {
			Optional<Account> accountOpt = this.accounts.stream()
														.filter(a -> a.getAccountId() == id)
														.findFirst();
			
			if (accountOpt.isPresent()) {
				Account account = accountOpt.get();
				return account;
			} else {
				return null;
			}
		}
		
		public Account findAccountByCustomerId(int id) {
			Optional<Account> accountOpt = this.accounts.stream()
														.filter(a -> a.getCustomerId() == id)
														.findFirst();
			
			if (accountOpt.isPresent()) {
				Account account = accountOpt.get();
				return account;
			} else {
				return null;
			}
		}
}
