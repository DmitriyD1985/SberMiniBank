package servlets;


import dataBase.LoginDao;
import dataBase.UserOperationListDao;
import entities.UserOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.ArrayList;



public class EnterServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(EnterServlet.class);

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String n=request.getParameter("username");
        String p=request.getParameter("userpass");

        if(LoginDao.validate(n, p)){
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("name");
            if(name == null) {
                session.setAttribute(n, n);
                log.info("Пользователь залогинился под именемЖ "+n);
            }
            else {
                session.removeAttribute("name");
            }
            request.setAttribute("usernameAnswer", n);
            ArrayList<UserOperation> list = UserOperationListDao.getAllOperations(n);
            request.setAttribute("operations", list);
            getServletContext().getRequestDispatcher("/operationHistory.jsp").forward(request, response);
        }
        else{
            System.out.println("Пользователь с таким логином не существует");
            request.setAttribute("usernameAnswer", n);
            getServletContext().getRequestDispatcher("/enter.jsp").forward(request, response);
        }
    }
}