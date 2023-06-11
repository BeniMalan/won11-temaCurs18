package org.fasttrackit.Budget.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.fasttrackit.Budget.Exception.ResourceNotFoundException;
import org.fasttrackit.Budget.Transaction;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TransactionService {
private final TransactionReader transactionReader;
private final TransactionRepository transactionRepository;

    @PostConstruct
    public void init()  {
        List<Transaction>transactions= null;
        try {
            transactions = transactionReader.Reader ();
        } catch (FileNotFoundException e) {
            throw new RuntimeException ( e );
        }
        transactionRepository.saveAll ( transactions );
    }

    public List<Transaction> getAll()  {
        return StreamSupport.stream ( transactionRepository.findAll ().spliterator (),false ).toList ();
    }
    public Transaction getByID(int id)  {
        return (Transaction) getAll ().stream ().filter ( transaction -> transaction.getId () == id ).findFirst ().orElseThrow (()-> new ResourceNotFoundException ("Tranzaction not found ",id) );
    }

    public Transaction deleteByID(int id)  {
        Transaction transaction = null;
        transaction = getByID (id);
        transactionRepository.delete ( transaction );
        return transaction;
    }
public Transaction addTransaction(Transaction transaction){
        transactionRepository.save ( transaction );
        return transaction;
    }
    public Transaction replaceTransaction(Transaction transaction){
        transactionRepository.findById ( getAll ().set ( 1,addTransaction ( transaction )).getId () );
return transaction;
    }
}

