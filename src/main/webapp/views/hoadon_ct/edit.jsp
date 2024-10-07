<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản lý hóa đơn chi tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Quản lý hóa đơn chi tiết</h1>
    <form method="post" action="/hoadon-ct/update/${data.id}">
        <div class="mb-3">
            <label for="idHoaDon" class="form-label">ID Hóa đơn:</label>
            <input type="text" class="form-control" id="idHoaDon" name="idHoaDon" value="${data.idHoaDon}">
            <c:if test="${not empty errors['idHoaDon']}">
                <small style="color: red">${errors['idHoaDon']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="idSPCT" class="form-label">ID Sản phẩm chi tiết:</label>
            <input type="text" class="form-control" id="idSPCT" name="idSPCT" value="${data.idSPCT}">
            <c:if test="${not empty errors['idSPCT']}">
                <small style="color: red">${errors['idSPCT']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">Số lượng:</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" value="${data.soLuong}">
            <c:if test="${not empty errors['soLuong']}">
                <small style="color: red">${errors['soLuong']}</small>
            </c:if>
        </div>
        <div class="mb-3">
            <label for="donGia" class="form-label">Đơn giá:</label>
            <input type="number" class="form-control" id="donGia" name="donGia" value="${data.donGia}">
            <c:if test="${not empty errors['donGia']}">
                <small style="color: red">${errors['donGia']}</small>
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
        <button class="btn btn-success">Lưu</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
