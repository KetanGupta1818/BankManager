package com.example.bankmanagement;

import com.example.database.InitialNames;
import com.example.database.InitialTransactions;

import java.io.IOException;
import java.util.*;

public class OnlineMain {
    public static String CURRENT_NAME;
    public static List<Party> people = new ArrayList<>();
    public static List<Transaction> transactionList = new ArrayList<>();

    public static void initiateOnlineMain() throws IOException {
        people = InitialNames.getListOfInitialParties();
        transactionList = InitialTransactions.getListOfTransaction();
    }


}
