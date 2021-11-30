package com.example.bankmanagement;

import com.example.database.InitialNames;
import com.example.database.WriteName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="createAccountServlet",value="/create_AccountServlet")
public class CreateAccountServlet extends HelloServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out  = response.getWriter();
        String newName = request.getParameter("Name");
        String password = request.getParameter("Password");
        OnlineMain.initiateOnlineMain();
        Party currentPerson = new Party(Integer.toString(++InitialNames.ACCOUNT_NUMBER_INDEX),
                newName,password,0);
        InitialNames.mapOfNames.put(newName,currentPerson);
        OnlineMain.people.add(currentPerson);
        WriteName.writeNamesToFile(OnlineMain.people);
        out.println(newName+" your Account is created successfully");
        RequestDispatcher rd = request.getRequestDispatcher("NewAccountCreated.jsp");
        rd.include(request,response);

    }
}
