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
    <title>Đăng ký</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
        }
        .register-container {
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
<div class="register-container">
    <div class="form-header">
        <h2>Đăng ký</h2>
    </div>
    <form action="/login/dk" method="post">
        <div class="mb-3">
            <label for="tk" class="form-label">Tên tài khoản</label>
            <input type="text" class="form-control" id="tk" name="usern" required>
        </div>
        <div class="mb-3">
            <label for="mk" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="mk" name="passw" required>
        </div>
        <div class="mb-3">
            <label for="quyen" class="form-label">Quyền truy cập</label>
            <select class="form-select" id="quyen" name="quyen" required>
                <option value="1">Admin</option>
                <option value="0">Nhân viên</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
        <span style="color: red">${er}</span>
    </form>
</div>
</body>
</html>
