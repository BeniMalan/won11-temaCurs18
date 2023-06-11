package org.fasttrackit.Budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAll ();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionsWithID(@PathVariable int id) {
        return transactionService.getByID ( id );

    }

    @DeleteMapping("/{id}")
    public Transaction deleteTransactionnWithID(@PathVariable int id) {
        return transactionService.deleteByID ( id );
    }

    @PostMapping("/add")
    public Transaction addNewTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction ( transaction );
    }

    @PutMapping("{id}")
    public Transaction replaceTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return transactionService.replaceTransaction ( id, transaction );
    }
}