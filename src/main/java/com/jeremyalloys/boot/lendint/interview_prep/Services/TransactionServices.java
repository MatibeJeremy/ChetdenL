package com.jeremyalloys.boot.lendint.interview_prep.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremyalloys.boot.lendint.interview_prep.Models.Transaction;
import com.jeremyalloys.boot.lendint.interview_prep.Repos.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

// I used this Service as a way to perform actions on my DB. Modulerizing stuff
// helps me visualize things better. Maybe it'll help you too. 
@Service
public class TransactionServices {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServices(TransactionRepository transactionRepository){
        super();
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        this.transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
