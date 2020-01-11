package servlets;


import dataBase.LoginDao;
import dataBase.LogonDao;
import dataBase.UserOperationListDao;
import entities.UserOperation;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RegistrationServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(RegistrationServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fio = request.getParameter("fio");
        String n = request.getParameter("username");
        String p = request.getParameter("userpass");

        if(LogonDao.validate(fio, n, p)){
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("name");
            if(name == null) {
                session.setAttribute(n, n);
                log.info("Пользователь залогинился под именемЖ "+n);
            }
            else {
                session.removeAttribute("name");
            }

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