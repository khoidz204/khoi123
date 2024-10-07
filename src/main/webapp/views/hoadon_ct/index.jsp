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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh sách hóa đơn chi tiết</h1>
<div class="container">
    <table class="table table-hover" border="1">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Id hóa đơn</th>
            <th>Id sản phẩm chi tiết</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.content}" var="hdct" varStatus="h">
            <tr>
                <td>${h.index + 1}</td>
                <td>${hdct.id}</td>
                <td>${hdct.idHoaDon}</td>
                <td>${hdct.idSPCT}</td>
                <td>${hdct.soLuong}</td>
                <td>${hdct.donGia}</td>
                <td>${hdct.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                <td>
                    <a href="/hoadon-ct/edit/${hdct.id}"class="btn btn-warning">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
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
            <c:set var="startPage" value="${currentPage - 2}" />
            <c:choose>
                <c:when test="${startPage lt 1}">
                    <c:set var="startPage" value="1" />
                </c:when>
            </c:choose>

            <c:set var="endPage" value="${currentPage + 2}" />
            <c:choose>
                <c:when test="${endPage gt totalPages}">
                    <c:set var="endPage" value="${totalPages}" />
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
</body>
<script>
    function redirectwithparam(page,limit){
        window.location.href= (window.location.origin + window.location.pathname) + "?page"+"="+page+"&"+ "?limit"+"="+limit
    }
</script>
</html>