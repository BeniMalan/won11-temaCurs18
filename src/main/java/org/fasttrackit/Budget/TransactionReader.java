package org.fasttrackit.Budget.service;

import org.fasttrackit.Budget.Transaction;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class TransactionReader {

    public List<Transaction> Reader() throws FileNotFoundException {
        List<Transaction> myList = new ArrayList<> ();
        try {
            Scanner scanner = new Scanner ( new File ( "src/main/resources/transactions" ) );
            while (scanner.hasNext ()) {
                String line = scanner.nextLine ();
                String[] tokens = line.split ( "\\|" );
                {
                    myList.add ( new Transaction ( Integer.parseInt ( tokens[0] ), tokens[1], tokens[2], Double.parseDouble ( tokens[3] ) ) );

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException ();
        }
        return myList;
    }
}

