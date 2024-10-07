<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5 mb-4">Danh Sách Nhân Viên</h1>
    <div class="row mb-3">
        <div class="col">
            <a href="/nhan-vien/create" class="btn btn-success">Thêm Nhân Viên</a>
        </div>
        <div class="col-8">
            <form action="/nhan-vien/index" class="row g-3">
                <div class="col">
                    <input type="text" class="form-control" name="keyword" placeholder="Tìm kiếm theo tên">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-light">Tìm kiếm</button>
                </div>
            </form>
        </div>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Tên</th>
            <th>Mã</th>
            <th>Tên Đăng Nhập</th>
            <th>Mật Khẩu</th>
            <th>Trạng Thái</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="nv" varStatus="n">
            <tr>
                <td>${n.index + 1}</td>
                <td>${nv.id}</td>
                <td>${nv.ten}</td>
                <td>${nv.ma}</td>
                <td>${nv.tenDN}</td>
                <td>${nv.mk}</td>
                <td>${nv.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/nhan-vien/edit/${nv.id}" class="btn btn-warning btn-sm">Update</a>
                    <a href="/nhan-vien/delete/${nv.id}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-center">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
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
