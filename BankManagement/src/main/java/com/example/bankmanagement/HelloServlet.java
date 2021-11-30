package com.example.bankmanagement;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        OnlineMain.initiateOnlineMain();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Optional<Party> currentPersonOptional = OnlineMain.people.stream()
                .filter(person->person.getName().equals(name))
                .findFirst();
        if(!currentPersonOptional.isPresent()){
            RequestDispatcher wrongName = request.getRequestDispatcher("incorrectName.jsp");
            wrongName.include(request,response);
            return;
        }
        Party currentPerson = currentPersonOptional.get();
        if(!currentPerson.getPassword().equals(password)){
            RequestDispatcher wrongPassword = request.getRequestDispatcher("incorrectPassword.jsp");
            wrongPassword.include(request,response);
        }
        else{out.println("Welcome "+name);
            OnlineMain.CURRENT_NAME = name;
        RequestDispatcher rd11 = request.getRequestDispatcher("SuccessfulLogin.jsp");
        rd11.include(request,response);}

    }

    public void destroy() {
    }
}