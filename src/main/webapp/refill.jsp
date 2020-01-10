<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пополнение</title>
</head>
<body>
<style>
    form {
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
<h3>Форма входа</h3>
<form action="refillAccount" method="post">
    Введите сумму для пополнения:<input type="number" name="refill"/><br/><br/>
    <input type="submit" value="Пополнить"/>
</form>
</body>
</html>
