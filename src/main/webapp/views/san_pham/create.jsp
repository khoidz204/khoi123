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
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Quản lý sản phẩm</h1>
    <form method="post" action="/san-pham/store">
        <div class="mb-3">
            <label for="ma" class="form-label">Mã:</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${data.ma}">
            <c:if test="${ not empty errors['ma'] }">
                <small class="text-danger">${ errors['ma'] }</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${data.ten}">
            <c:if test="${ not empty errors['ten'] }">
                <small class="text-danger">${ errors['ten'] }</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái:</label>
            <select class="form-select" id="trangThai" name="trangThai">
                <option value="1">Ngừng hoạt động</option>
                <option value="0">Đang hoạt động</option>
            </select>
            <c:if test="${ not empty errors['trangThai'] }">
                <small class="text-danger">${ errors['trangThai'] }</small>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>
</body>
</html>
