package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts; // object reference

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();

	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = Long.valueOf(accounts.size() + 1);
		CommercialAccount account = new CommercialAccount(company,accountNumber , pin, startingDeposit);
		accounts.put(accountNumber,account);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = Long.valueOf(accounts.size() + 1);
		ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber,account);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		return this.getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		this.getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		double balance = this.getBalance(accountNumber);
		if (balance < amount) {
			return false;
		} else {
				this.getAccount(accountNumber).debitAccount(amount);
				return true;
		}		
	}
}
