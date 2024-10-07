<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
</head>
<body>
<h1>Trang Login</h1>
<form method="post" action="/post">
    <div>
        Email:
        <input name="email">
    </div><div>
        Password:
        <input name="pw">
    </div><div>
        <button>Login</button>
    </div>
</form>
</body>
</html>