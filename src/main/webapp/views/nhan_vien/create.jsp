<%@ page pageEncoding="UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm nhân viên mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Thêm nhân viên mới</h1>
    <form method="post" action="/nhan-vien/store">
        <div class="mb-3">
            <label for="ten" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${data.ten}">
            <c:if test="${not empty errors['ten']}">
                <small style="color: red">${errors['ten']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Mã:</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${data.ma}">
            <c:if test="${not empty errors['ma']}">
                <small style="color: red">${errors['ma']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="tenDN" class="form-label">Tên đăng nhập:</label>
            <input type="text" class="form-control" id="tenDN" name="tenDN" value="${data.tenDN}">
            <c:if test="${not empty errors['tenDN']}">
                <small style="color: red">${errors['tenDN']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="mk" class="form-label">Mật khẩu:</label>
            <input type="password" class="form-control" id="mk" name="mk" value="${data.mk}">
            <c:if test="${not empty errors['mk']}">
                <small style="color: red">${errors['mk']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái:</label>
            <select class="form-select" id="trangThai" name="trangThai">
                <option value="1">Đang hoạt động</option>
                <option value="0">Ngừng hoạt động</option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small style="color: red">${errors['trangThai']}</small>
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
