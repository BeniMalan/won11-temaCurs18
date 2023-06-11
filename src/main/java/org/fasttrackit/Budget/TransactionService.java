package org.fasttrackit.Budget;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
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
        return getAll ().stream()
                .filter(transaction-> transaction.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Not found", id));
    }

    public Transaction deleteByID(int id)  {
       Transaction transaction = getByID (id);
        transactionRepository.delete ( transaction );
        return transaction;
    }
public Transaction addTransaction(Transaction transaction){
        transactionRepository.save ( transaction );
        return transaction;
    }
    public Transaction replaceTransaction(int id, Transaction transaction) {
        Transaction tr = getByID(id);
        tr.setProduct(transaction.getProduct());
        tr.setAmount(transaction.getAmount());
        tr.setType(transaction.getType());
        transactionRepository.save ( tr );
        return transaction;
    }
}



