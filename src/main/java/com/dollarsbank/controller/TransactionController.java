package com.dollarsbank.controller;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Transaction;

public class TransactionController {
	
	private ArrayList<Transaction> transactions;

	
	
	public TransactionController() {
		super();
		this.transactions = new ArrayList<Transaction>();
		addTransaction(new Transaction(1,3,"SHOULD NOT SHOW"));
		addTransaction(new Transaction(2,1,"First deposit of a lot"));
		addTransaction(new Transaction(3,3,"2nd deposit, getting some money"));
		addTransaction(new Transaction(4,3,"withdrew way too much"));
		addTransaction(new Transaction(5,4,"Who are you, Yu, No not me you, I just told you, Are you deaf, No Yu is blind"));
		addTransaction(new Transaction(6,2,"SHOULD NOT SHOW"));
		addTransaction(new Transaction(7,1,"Playing football and making a lot"));
		addTransaction(new Transaction(8,4,"I'm not blind you blind, That is what I said, Shut up! You, Yes?"));
		addTransaction(new Transaction(9,3,"getting some funds back"));
		addTransaction(new Transaction(10,2,"BIG MONEY FROM DOGECOIN"));
		addTransaction(new Transaction(11,2,"And now its all gone"));
		addTransaction(new Transaction(12,2,"rubbing two nickels together"));
		addTransaction(new Transaction(13,1,"Money money money mooonney"));
		addTransaction(new Transaction(14,1,"....mooonney"));
		addTransaction(new Transaction(15,4,"No not you him what's your name, Mi, YES YOU, I am Mi, He is Mi, and I am Yu"));
		addTransaction(new Transaction(16,3,"doing alright"));
		addTransaction(new Transaction(17,3,"hey....could be worst"));
		addTransaction(new Transaction(18,1,"I think he's pretty good"));
		addTransaction(new Transaction(19,2,"make 2 into 4 and 4 into mo"));
		addTransaction(new Transaction(20,2,"almost 10 dollars"));
	}
	
	public TransactionController(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public boolean addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
		return true;
	}
	
	
	public ArrayList<Transaction> findTransactionsByAccountId(int id){
		ArrayList<Transaction> transactionsOpt = (ArrayList<Transaction>) this.transactions.stream()
																	.filter(t -> t.getAccountId() == id)
																	.collect(Collectors.toCollection(ArrayList::new));

		if (transactionsOpt!=null) {
			return transactionsOpt;
		} else {
		return null;
		}
	}
	
	public ArrayList<Transaction> findLastFiveTransactionsByAccountId(int accountId){
		ArrayList<Transaction> transactionOpt = (ArrayList<Transaction>) this.transactions.stream()
																						.filter(t -> t.getAccountId() == accountId)
																						.collect(lastN(5)); // this is where i use helper static method lastN(int n)
		if(!transactionOpt.isEmpty()) {
			return transactionOpt;
		} else {
			return null;
		}
		
	}
	
	public static <T> Collector<T, ?, List<T>> lastN(int n) {
	    return Collector.<T, Deque<T>, List<T>>of(ArrayDeque::new, (acc, t) -> { 
	    																		if(acc.size() == n) acc.pollFirst();
																		        acc.add(t);
																		        }
	    														 , (acc1, acc2) -> {
																				     while(acc2.size() < n && !acc1.isEmpty()) {
																				          acc2.addFirst(acc1.pollLast());
																				        }
																			        return acc2;
																			        }
	    														 , ArrayList::new);
	}
	
}
