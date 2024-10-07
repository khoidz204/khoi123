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
<h1>Danh sách sản phẩm chi tiết</h1>
<%--<form method="GET" action="/spct/index">--%>
<%--    <div class="container">--%>
<%--        Sản phẩm:--%>
<%--        &lt;%&ndash;    <select class="form-select" name="spId">&ndash;%&gt;--%>
<%--        &lt;%&ndash;        <c:forEach items="${listSP}" var="item">&ndash;%&gt;--%>
<%--        &lt;%&ndash;        <option value="${item.id}">${item.ten}</option>&ndash;%&gt;--%>
<%--        &lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>
<%--        &lt;%&ndash;    </select>&ndash;%&gt;--%>
<%--        <button type="submit" class="btn btn-success">Lọc</button>--%>
<%--    </div>--%>
<%--</form>--%>
<div class="container">
    <table class="table table-hover" border="1">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên sản phẩm</th>
            <th>Màu sắc</th>
            <th>Kích thước</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="spct" varStatus="s">
            <tr>
                <td>${s.index + 1}</td>
                <td>${spct.id}</td>
                <td>${spct.ma}</td>
                <td>${spct.sp.ten}</td>
                <td>${spct.ms.ten}</td>
                <td>${spct.kt.ten}</td>
                <td>${spct.soLuong}</td>
                <td>${spct.donGia}</td>
                <td>${spct.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/spct/edit/${spct.id}" class="btn btn-warning">Update</a>
                </td>
                <td>
                    <a href="/spct/delete/${spct.id}" class="btn btn-danger">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <!-- Previous Button -->
                <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                    <a class="page-link" href="?page=${currentPage - 1}&limit=${pageSize}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>

                <!-- Page Numbers -->
                <c:set var="startPage" value="${currentPage - 2}"/>
                <c:choose>
                    <c:when test="${startPage lt 1}">
                        <c:set var="startPage" value="1"/>
                    </c:when>
                </c:choose>

                <c:set var="endPage" value="${currentPage + 2}"/>
                <c:choose>
                    <c:when test="${endPage gt totalPages}">
                        <c:set var="endPage" value="${totalPages}"/>
                    </c:when>
                </c:choose>

                <c:forEach var="i" begin="${startPage}" end="${endPage}">
                    <li class="page-item ${currentPage == i ? 'active' : ''}">
                        <a class="page-link" href="?page=${i}&limit=${pageSize}">${i}</a>
                    </li>
                </c:forEach>

                <!-- Next Button -->
                <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                    <a class="page-link" href="?page=${currentPage + 1}&limit=${pageSize}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>