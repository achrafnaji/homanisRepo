package com.services;

import java.util.List;

import com.model.Transaction;

public interface TransactionService {

	Transaction saveTransaction(Transaction transaction);

	Long numbersOfTransactions();

	List<Transaction> findAllTransactions();

}
