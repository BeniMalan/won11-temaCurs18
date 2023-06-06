package org.fasttrackit.Budget;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
public class TransactionService {
private final TransactionReader transactionReader;
private final List<Transaction>transactionList=new ArrayList<> ();

    public TransactionService(TransactionReader transactionReader) {
        this.transactionReader = transactionReader;
    }
    @PostConstruct
    public void init() throws FileNotFoundException {
        transactionList.addAll ( transactionReader.Reader ());
        System.out.println (transactionList);
    }

    public List<Transaction> getAll() throws FileNotFoundException {
        return transactionList;
    }

    public Transaction getByID(int id) throws FileNotFoundException {
        return (Transaction) getAll ().stream ()
                .filter ( transaction -> transaction.getId ()==id).findFirst ().orElse ( null );
    }
    public Transaction deleteByID(int id) throws FileNotFoundException {
        Transaction transaction = getByID (id);
        transactionList.remove(transaction);
        return transaction;
    }
public Transaction addTransaction(Transaction transaction){
        transactionList.add ( transaction );
        return transaction;
    }
    public Transaction replaceTransaction(Transaction transaction){
        transactionList.set ( 0,transaction );
        return transaction;
    }
    public Map<String,List<Transaction>>report (){
        Map<String,List<Transaction>> myreportBytype=transactionList.stream ().collect ( Collectors.groupingBy ( Transaction::getType) );
         return myreportBytype;
    }
    public Map<String,List<Transaction>>report2(){
        Map<String,List<Transaction>>myreportByProduct=transactionList.stream ().collect ( Collectors.groupingBy ( Transaction::getProduct ) );
        return myreportByProduct;
    }
}

