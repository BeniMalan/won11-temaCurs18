package org.fasttrackit.Budget.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@AllArgsConstructor
@Getter
@EntityScan

public class Transaction {
 @Id
 @GeneratedValue
private  int  id;
 @Column
private  String product;
 @Column
private  String type;
 @Column
private  double amount;
}
