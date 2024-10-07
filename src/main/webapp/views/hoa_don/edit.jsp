<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản lý hóa đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Quản lý hóa đơn</h1>
    <form method="post" action="/hoa-don/update/${data.id}">
        <div class="mb-3">
            <label for="idNhanVien" class="form-label">ID Nhân viên:</label>
            <input type="text" class="form-control" id="idNhanVien" name="idNhanVien" value="${data.idNhanVien}">
            <c:if test="${not empty errors['idNhanVien']}">
                <small style="color: red">${errors['idNhanVien']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="idKhachHang" class="form-label">ID Khách hàng:</label>
            <input type="text" class="form-control" id="idKhachHang" name="idKhachHang" value="${data.idKhachHang}">
            <c:if test="${not empty errors['idKhachHang']}">
                <small style="color: red">${errors['idKhachHang']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="ngayMua" class="form-label">Ngày mua:</label>
            <input type="date" class="form-control" id="ngayMua" name="ngayMua" value="${data.ngayMua}">
            <c:if test="${not empty errors['ngayMua']}">
                <small style="color: red">${errors['ngayMua']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái:</label>
            <select class="form-select" id="trangThai" name="trangThai">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>
                    Đã thanh toán
                </option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>
                    Chưa thanh toán
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
