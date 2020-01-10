package servlets;

import dataBase.LogonDao;
import dataBase.RefilDao;
import dataBase.UserOperationListDao;
import entities.User;
import entities.UserOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class RefillAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("refill.jsp");
        requestDispatcher.forward(req, resp);
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name= null;
            HttpSession session = req.getSession();
            Enumeration eNames = session.getAttributeNames();
            while (eNames.hasMoreElements()) {
                String attributeName = (String) eNames.nextElement();
                name =attributeName;
            }
            String sum = req.getParameter("refill");
            if(RefilDao.refilAckount(name, sum)){
                System.out.println("Счет поплненн");
                req.setAttribute("usernameAnswer", name);
                req.setAttribute("refillSum", sum);
                ArrayList<UserOperation> list = UserOperationListDao.getAllOperations(name);
                req.setAttribute("operations", list);
                getServletContext().getRequestDispatcher("/operationHistory.jsp").forward(req, resp);
            }
            else{String result = "Что то счет не пополняется";
                System.out.println(result);
                req.setAttribute("refillResult", result);
                 getServletContext().getRequestDispatcher("/operationHistory.jsp").forward(req, resp);
            }
        }}