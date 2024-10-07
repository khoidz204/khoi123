<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 20px;
        }
        .container {
            max-width: 500px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
<h1 class="mb-4">Quản lý sản phẩm</h1>
<form method="post" action="/san-pham/update/${data.id}">
    <div class="container">
        <div class="form-group">
            <label for="ma">Mã:</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${data.ma}">
            <c:if test="${ not empty errors['ma'] }">
                <small class="error-message">${ errors['ma'] }</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="ten">Tên:</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${data.ten}">
            <c:if test="${ not empty errors['ten'] }">
                <small class="error-message">${ errors['ten'] }</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng thái:</label>
            <select class="form-select" id="trangThai" name="trangThai">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Ngừng hoạt động</option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Đang hoạt động</option>
            </select>
            <c:if test="${ not empty errors['trangThai'] }">
                <small class="error-message">${ errors['trangThai'] }</small>
            </c:if>
        </div>
        <button type="submit" class="btn btn-success">Lưu</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
