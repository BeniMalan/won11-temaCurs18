package org.fasttrackit.Budget.Controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.Budget.Transaction;
import org.fasttrackit.Budget.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/t")
public class TransactionController {

    private final TransactionService transactionService;
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() throws FileNotFoundException {
       return transactionService.getAll ();
    }
    @GetMapping("/{id}")
    public Transaction getTranWithID(@PathVariable int id) throws FileNotFoundException {
        return transactionService.getByID (id);

    }
    @DeleteMapping("/{id}")
    public Transaction deleteTranwithID(@PathVariable int id) throws FileNotFoundException {
       return transactionService.deleteByID ( id );
    }
    @PostMapping
    public Transaction addNewTransaction(@RequestBody Transaction transaction){
           return transactionService.addTransaction ( transaction );
    }
}