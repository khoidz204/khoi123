<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Đăng nhập</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
        }
        .login-container {
            width: 100%;
            max-width: 400px;
            padding: 15px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-header {
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="login-container">
    <div class="form-header">
        <h2>Đăng nhập</h2>
    </div>
    <form action="/login/dn" method="post">
        <div class="mb-3">
            <label for="tk" class="form-label">Tên tài khoản</label>
            <input type="text" class="form-control" id="tk" name="usern" required>
        </div>
        <div class="mb-3">
            <label for="mk" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="mk" name="passw" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        <span style="color: red">${er}</span>
    </form>

    <div class="text-center mt-3">
        <a href="/login/formdk" class="btn btn-success">Đăng ký</a>
    </div>
</div>
</body>
</html>
