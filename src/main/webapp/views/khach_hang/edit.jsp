<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản lý khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Quản lý khách hàng</h1>
    <form method="post" action="/khach-hang/update/${data.id}">
        <div class="mb-3">
            <label for="maKH" class="form-label">Mã:</label>
            <input type="text" class="form-control" id="maKH" name="maKH" value="${data.maKH}">
            <c:if test="${not empty errors['maKH']}">
                <small style="color: red">${errors['maKH']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${data.ten}">
            <c:if test="${not empty errors['ten']}">
                <small style="color: red">${errors['ten']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="sdt" class="form-label">Số điện thoại:</label>
            <input type="text" class="form-control" id="sdt" name="sdt" value="${data.sdt}">
            <c:if test="${not empty errors['sdt']}">
                <small style="color: red">${errors['sdt']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái:</label>
            <select class="form-select" id="trangThai" name="trangThai">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>
                    Đang hoạt động
                </option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>
                    Ngừng hoạt động
                </option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small style="color: red">${errors['trangThai']}</small>
            </c:if>
        </div>
        <button type="submit" class="btn btn-success">Lưu</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
