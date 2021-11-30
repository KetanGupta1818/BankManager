package com.example.database;
import com.example.bankmanagement.Party;
import com.example.bankmanagement.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;
import java.util.stream.Collectors;

import static com.example.database.InitialNames.mapOfNames;

public class InitialTransactions {
    public static HashMap<Party,List<Transaction>> mapOfPartyAndTransaction = new HashMap<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static File file = new File("C:\\Users\\Admin\\Documents\\Intellij files\\Preloaded Transactions1.txt");

    public static Transaction getTransaction(String line){
        String[] arr = line.split(" ");
        Transaction cur = new Transaction(mapOfNames.get(arr[0]),LocalDate.parse(arr[2],formatter),mapOfNames.get(arr[1]),
                Integer.parseInt(arr[3]),arr[4]);
        if(mapOfPartyAndTransaction.containsKey(mapOfNames.get(arr[0]))){
            List<Transaction> temp = mapOfPartyAndTransaction.get(mapOfNames.get(arr[0]));
            temp.add(cur);
            mapOfPartyAndTransaction.put(mapOfNames.get(arr[0]),temp);
        }
        else{
            List<Transaction> l = new ArrayList<>();
            l.add(cur);
            mapOfPartyAndTransaction.put(mapOfNames.get(arr[0]),l );
        }
        return cur;
    }

    public static List<String> getStringTypeTransaction() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> stringTransactions = new ArrayList<>();
        String transaction;
        while((transaction=br.readLine())!=null){
            stringTransactions.add(transaction);
        }
        return stringTransactions;
    }

    public static List<Transaction> getListOfTransaction() throws IOException {
        List<String> stringTransactions = getStringTypeTransaction();
        return stringTransactions.stream()
                .map(InitialTransactions::getTransaction)
                .collect(Collectors.toList());
    }
}
