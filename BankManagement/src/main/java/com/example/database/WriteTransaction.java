package com.example.database;
import com.example.bankmanagement.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class WriteTransaction {
    public static File file = new File("C:\\Users\\Admin\\Documents\\Intellij files\\Preloaded Transactions1.txt");
    public static void writeTransactionToFile(List<Transaction> transactionList) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(Transaction transaction: transactionList){
            LocalDate date = transaction.getDate();
            writer.write(transaction.getSender().getName()+" "+transaction.getRecipient().getName()+" "+
                    date.toString()+" "+ transaction.getAmount() +" "+
                    transaction.getType()+"\n");

        }
        writer.close();
    }
}
