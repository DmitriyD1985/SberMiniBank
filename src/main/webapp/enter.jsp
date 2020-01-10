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
<h3>Форма входа</h3>
    <form action="enter" method="post">
        <p>Имя:</p>
        <input type="text" name="username"/><br/><br/>
        <p>Пароль:</p>
        <input type="password" name="userpass"/><br/><br/>
        <input type="submit" value="Войти"/>
    </form>
</div>
<%
    String name = (String) request.getAttribute("usernameAnswer");
    if (name != null){
        out.println("<h2>" + name +"- такой логин не зарегистрирован или не существует" + "</h2>");}
%>

</body>
</html>
