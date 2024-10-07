<%@ page pageEncoding="UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Quản lý nhân viên</h1>
    <form method="post" action="/nhan-vien/update/${data.id}">
        <div class="mb-3">
            <label for="ten" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${data.ten}">
            <c:if test="${not empty errors['ten']}">
                <small class="text-danger">${errors['ten']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Mã:</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${data.ma}">
            <c:if test="${not empty errors['ma']}">
                <small class="text-danger">${errors['ma']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="tenDN" class="form-label">Tên đăng nhập:</label>
            <input type="text" class="form-control" id="tenDN" name="tenDN" value="${data.tenDN}">
            <c:if test="${not empty errors['tenDN']}">
                <small class="text-danger">${errors['tenDN']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="mk" class="form-label">Mật khẩu:</label>
            <input type="text" class="form-control" id="mk" name="mk" value="${data.mk}">
            <c:if test="${not empty errors['mk']}">
                <small class="text-danger">${errors['mk']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái:</label>
            <select id="trangThai" name="trangThai" class="form-select">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Đang hoạt động</option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Ngừng hoạt động</option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small class="text-danger">${errors['trangThai']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <button class="btn btn-success">Lưu</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
