package org.fasttrackit.Budget;

import org.fasttrackit.Budget.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
}
