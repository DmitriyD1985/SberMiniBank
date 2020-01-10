<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.UserOperation" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<style>
    #tableOperation {
        margin: auto;
        margin-top: 100px;
        background-color: forestgreen;
        text-align: center;
        color: white;
        width: 500px;
    }
    body{
        margin: auto;
    }
    input
    {
        color: black;
        background-color: antiquewhite;
    }
    p{
        font-size: 15px;
    }
</style>

<%
    String name = (String) request.getAttribute("usernameAnswer");
    if (name != null){
        out.println("<h2>" + name +"- user is entered" + "</h2>");}
%>
<div>
    <div>
        <div>
            <h2>Список операция пользователя</h2>
        </div>
        <table border='3' align='center' id="tableOperation">
            <tr>
                <th>Имя операции</th>
                <th>Сумма</th>
                <th>Получатель</th>
                <th>Отправитель</th>
            </tr>
                <%List<UserOperation> userOperations = (List<UserOperation>) request.getAttribute("operations");
            if (userOperations != null && !userOperations.isEmpty()) {

                for (UserOperation s : userOperations) {
                    out.println("<tr>");
                    out.println("<td>" + s.getOperationName() + "</td>");
                    out.println("<td>" + s.getOperationSum() + "</td>");
                    out.println("<td>" + s.getOperationContrAgentLogin() + "</td>");
                    out.println("<td>" + s.getUserLogin() + "</td>");
                    out.println("</tr>");
                }
            } else out.println("<p>List of userOeration is empty</p>");
        %>
 <%
    String refillAckount = (String) request.getAttribute("usernameAnswer");
    String refillSum = (String) request.getAttribute("refillSum");
    if (refillAckount != null && refillSum!=null){
        out.println("<h2>Аккаунт " + refillAckount +" пополнен на сумму " +refillSum+ "</h2>");}
%>

                <%
    String recipientName = (String) request.getAttribute("recipientName");
    String transferSum = (String) request.getAttribute("transferSum");
    if (recipientName != null && transferSum!=null){
        out.println("<h2>Аккаунт " + recipientName +" пополнен на сумму " +transferSum+ "</h2>");}
%>
            <a href="transfer.jsp">Перевод</a>
            <a href="refill.jsp">Пополнение</a>

</body>
</html>