package servlets;

import dataBase.RefilDao;
import dataBase.TransferDao;
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

public class TransferServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("transfer.jsp");
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
        String sum = req.getParameter("transfer");
        String contrAgent = req.getParameter("yourcontragent");

        if(TransferDao.transfer(name, contrAgent, sum)){
            req.setAttribute("recipientName", contrAgent);
            req.setAttribute("transferSum", sum);
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