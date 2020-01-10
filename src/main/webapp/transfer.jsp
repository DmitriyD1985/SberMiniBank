<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Перевод</title>
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
<form action="transfer" method="post">
    Введите Login получателя<input type="text" name="yourcontragent"/><br/><br/>
    Введите сумму для пополнения:<input type="number" name="transfer"/><br/><br/>
    <input type="submit" value="Пополнить"/>
</form>
</body>
</html>
