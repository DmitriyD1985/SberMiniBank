package servlets;


import dataBase.LoginDao;
import dataBase.LogonDao;
import dataBase.UserOperationListDao;
import entities.UserOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RegistrationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fio = request.getParameter("fio");
        String n = request.getParameter("username");
        String p = request.getParameter("userpass");

        if(LogonDao.validate(fio, n, p)){
            System.out.println("Пользователь " + n+" зарегстрирован");
            ArrayList<UserOperation> list = UserOperationListDao.getAllOperations(n);
            request.setAttribute("username", n);
            request.setAttribute("operations", list);
            getServletContext().getRequestDispatcher("/operationHistory.jsp").forward(request, response);
        }
        else{
            System.out.println("Пользователь с таким логином уже существует");
            request.setAttribute("usernameAnswer", n);
            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        }

    }
}