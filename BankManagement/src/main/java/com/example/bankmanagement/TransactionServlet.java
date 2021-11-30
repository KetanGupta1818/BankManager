package com.example.bankmanagement;

import com.example.database.InitialNames;
import com.example.database.InitialTransactions;
import com.example.database.WriteTransaction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

@WebServlet(name = "transactionServlet", value="/transactionServlet")
public class TransactionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String receiverName = request.getParameter("receiver");
        String amount = request.getParameter("amount");
        String senderName = OnlineMain.CURRENT_NAME;
        PrintWriter out = response.getWriter();
        if(!InitialNames.mapOfNames.containsKey(receiverName)){
            out.print("Enter a name which is in the network");
            return;
        }
        Party Sender = InitialNames.mapOfNames.get(senderName);
        Party Receiver = InitialNames.mapOfNames.get(receiverName);
        Transaction newTransaction = new Transaction(Sender, LocalDate.now(), Receiver,
                Integer.parseInt(amount),"transfer");
        transactionSetter(Sender, newTransaction);
        transactionSetter(Receiver, newTransaction);
        OnlineMain.transactionList.add(newTransaction);
        WriteTransaction.writeTransactionToFile(OnlineMain.transactionList);
    }

    public static  void transactionSetter(Party person, Transaction newTransaction) {
        if(InitialTransactions.mapOfPartyAndTransaction.containsKey(person)){
            List<Transaction> l = InitialTransactions.mapOfPartyAndTransaction.get(person);
            l.add(newTransaction);
            InitialTransactions.mapOfPartyAndTransaction.put(person,l);
        }
        else{
            List<Transaction> k = new ArrayList<>();
            k.add(newTransaction);
            InitialTransactions.mapOfPartyAndTransaction.put(person,k);
        }
    }
}
