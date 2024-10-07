<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1>Quản lý sản phẩm chi tiết</h1>
<form method="post" action="/spct/update/${data.id}">
    <div class="container">
        <div>
            Mã:
            <input type="text" name="ma" value="${data.ma}">
            <c:if test="${ not empty errors['ma'] }">
                <small style="color: red">${ errors['ma'] }</small>
            </c:if>
        </div><div>
            Tên sản phẩm:
            <input type="text" name="sp.ten" value="${data.sp.ten}">
            <c:if test="${ not empty errors['sp.ten'] }">
                <small style="color: red">${ errors['sp.ten'] }</small>
            </c:if>
        </div>
        <div>
            Màu sắc:
            <input type="text" name="ms.ten" value="${data.ms.ten}">
            <c:if test="${ not empty errors['ms.ten'] }">
                <small style="color: red">${ errors['ms.ten'] }</small>
            </c:if>
        </div>
        <div>
            Kích thước:
            <input type="text" name="kt.ten" value="${data.kt.ten}">
            <c:if test="${ not empty errors['kt.ten'] }">
                <small style="color: red">${ errors['kt.ten'] }</small>
            </c:if>
        </div>
        <div>
            Số lượng:
            <input type="text" name="ten" value="${data.soLuong}">
            <c:if test="${ not empty errors['soLuong'] }">
                <small style="color: red">${ errors['soLuong'] }</small>
            </c:if>
        </div>
        <div>
            Đơn giá:
            <input type="text" name="ten" value="${data.donGia}">
            <c:if test="${ not empty errors['donGia'] }">
                <small style="color: red">${ errors['donGia'] }</small>
            </c:if>
        </div>
        Trạng thái
        <select name="trangThai">
            <option value="1">Đang hoạt động</option>
            <option value="0">Ngừng hoạt động</option>
        </select>
    </div>
    <button>Lưu</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>