package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Transaction;
import com.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction saveTransaction(final Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	@Override
	public Long numbersOfTransactions() {
		return transactionRepository.count();
	}
	@Override
	public List<Transaction> findAllTransactions(){
		return transactionRepository.findAll();
	}
}
