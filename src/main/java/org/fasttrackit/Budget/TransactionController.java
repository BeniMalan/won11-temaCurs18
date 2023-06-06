package org.fasttrackit.Budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

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
    @PutMapping
    public Transaction replaceTransaction(@RequestBody Transaction transaction){
        return transactionService.replaceTransaction ( transaction );
    }
    @GetMapping("/r")
    public Map<String,List<Transaction>> getReportBytype(){
        return transactionService.report ();
    }
    @GetMapping("/r2")
    public Map<String,List<Transaction>>getReportByProduct(){
        return transactionService.report2 ();
    }
}