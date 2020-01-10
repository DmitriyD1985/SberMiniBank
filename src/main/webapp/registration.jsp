<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Регистрация в минибанке</title>
</head>
<body>
<style>
    #forma {
        margin: auto;
        margin-top: 100px;
        background-color: forestgreen;
        text-align: center;
        color: white;
        width: 500px;
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

<div id="forma">
<h3>Форма регистрации</h3>
    <form action="registration" method="post">
        <p>ФИО:</p>
        <input type="text" name="fio" size="45"/><br/><br/>
        <p>Имя:</p>
        <input type="text" name="username" size="45"/><br/><br/>
        <p>Пароль:</p>
        <input type="password" name="userpass" size="45"/><br/><br/>
        <input type="submit" value="Зарегестрироваться"/>
    </form>
</div>>
<%
        String name = (String) request.getAttribute("usernameAnswer");
    if (name != null){
            out.println("<h2>" + name +"- такое логин уже существует" + "</h2>");}
%>

</body>
</html>
