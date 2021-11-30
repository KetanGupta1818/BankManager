package com.example.bankmanagement;

import com.example.database.InitialNames;
import com.example.database.InitialTransactions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name="functionServlet", value="/functionServlet")
public class FunctionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String choice = request.getParameter("choice");
        PrintWriter out = response.getWriter();
        switch (choice) {
            case "checkBalance":
                out.println("Your current balance is: " + InitialNames.mapOfNames.get(OnlineMain.CURRENT_NAME).getBalance());
                break;
            case "viewTransactions":
                Party currentPerson = InitialNames.mapOfNames.get(OnlineMain.CURRENT_NAME);
                List<Transaction> transactionList = InitialTransactions.getListOfTransaction().stream()
                        .filter(transaction -> (transaction.getRecipient().getName().equals(currentPerson.getName())||
                                transaction.getSender().getName().equals(currentPerson.getName())))
                        .collect(Collectors.toList());

                if (transactionList.isEmpty()) {
                    out.print("No transactions yet");
                } else {
                    for (Transaction transaction : transactionList) {
                        out.println(transaction.getTransactionDetails());
                    }
                }
                break;
            case "transferMoney":
                RequestDispatcher rde = request.getRequestDispatcher("transferMoney.jsp");
                rde.include(request, response);
                break;
            case "depositMoney":
                RequestDispatcher rde2 = request.getRequestDispatcher("depositMoney.jsp");
                rde2.include(request,response);
                break;
        }

    }
}
