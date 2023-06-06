package org.fasttrackit.Budget;

import lombok.*;

@Data

public class Transaction {
private final int  id;
private final String product;
private final String type;
private final double amount;
}
