package com.example.bankmanagement;
import com.example.database.InitialNames;
import com.example.database.InitialTransactions;
import com.example.database.WriteName;
import com.example.database.WriteTransaction;

import java.io.IOException;
import java.util.*;
public class OfflineMain {
    public static List<Party> people;
    public static void main(String[] args) throws IOException {

        people = InitialNames.getListOfInitialParties();
        people.forEach(person->System.out.println(person.getDetails()));
        List<Transaction> transactionList = InitialTransactions.getListOfTransaction();
        transactionList.forEach(tran->System.out.println(tran.getTransactionDetails()));
        people.forEach(person->System.out.println(person.getDetails()));
        System.out.println("Passwords are:;::");
        people.forEach(person->System.out.println(person.getPassword()));
        WriteName.writeNamesToFile(people);
        WriteTransaction.writeTransactionToFile(transactionList);
    }
}
