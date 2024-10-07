<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 20px;
        }
    </style>
</head>
<body>
<h1 class="mt-5 mb-4">Danh sách sản phẩm</h1>
<div class="row mb-3">
    <div class="col">
        <a href="/san-pham/create" class="btn btn-success">Thêm sản phẩm</a>
    </div>
    <div class="col-8">
        <form action="/san-pham/index" class="row g-3">
            <div class="col">
                <input type="text" class="form-control" name="keyword" placeholder="Tìm kiếm theo tên">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-light">Tìm kiếm</button>
            </div>
        </form>
    </div>
</div>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="sp" varStatus="s">
            <tr>
                <td>${s.index + 1}</td>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>${sp.trangThai == 1 ? "Ngừng hoạt động" : "Đang hoạt động"}</td>
                <td>
                    <a href="/san-pham/edit/${sp.id}" class="btn btn-warning btn-sm">Update</a>
                    <a href="/san-pham/delete/${sp.id}" class="btn btn-danger btn-sm">Delete</a>
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
