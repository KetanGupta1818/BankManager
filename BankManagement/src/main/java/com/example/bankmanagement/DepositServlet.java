package com.example.bankmanagement;

import com.example.database.InitialNames;
import com.example.database.WriteTransaction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "depositServlet", value = "/depositServlet")
public class DepositServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer dAmount = Integer.parseInt(request.getParameter("dAmount"));
        String currentName = OnlineMain.CURRENT_NAME;
        Party currentPerson = InitialNames.mapOfNames.get(currentName);
        Transaction newTransaction = new Transaction(currentPerson, LocalDate.now(),currentPerson,dAmount,
                "deposit");
        TransactionServlet.transactionSetter(currentPerson,newTransaction);
        OnlineMain.transactionList.add(newTransaction);
        WriteTransaction.writeTransactionToFile(OnlineMain.transactionList);
    }
}
