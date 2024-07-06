package com.example.demo.Service;

import com.example.demo.Model.Transaction;
import com.example.demo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;


    public Transaction addTransaction(Transaction transaction){
       return transactionRepository.save(transaction);
    }
}
