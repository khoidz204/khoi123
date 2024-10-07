<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Trang chủ</h1>
<br/>
<div class="text-center">
    <c:choose>
        <c:when test="${not empty sessionScope.tentk}">
                    <c:choose>
                        <c:when test="${sessionScope.quyentk == 1}">
                            <a href="/hoa-don/index" class="mx-3" style="text-decoration: none">Hóa đơn</a>
                            <a href="/hoadon-ct/index" class="mx-3" style="text-decoration: none">Hóa đơn chi tiết</a>
                        </c:when>
                        <c:otherwise>
                            <span class="mx-3 text-muted">Hóa đơn (Quyền Admin)</span>
                            <span class="mx-3 text-muted">Hóa đơn chi tiết (Quyền Admin)</span>
                        </c:otherwise>
                    </c:choose>
            <a href="/khach-hang/index" class="mx-3" style="text-decoration: none">Khách hàng</a>
            <br/><br/>
            <a href="/kich-thuoc/index" style="text-decoration: none">Kích thước</a>
            <a href="/mau-sac/index" class="mx-3" style="text-decoration: none">Màu sắc</a>
            <a href="/nhan-vien/index" style="text-decoration: none">Nhân viên</a>
            <a href="/san-pham/index" class="mx-3" style="text-decoration: none">Sản phẩm</a>
            <br/><br/>
            <a href="/spct/index" class="mx-3" style="text-decoration: none">Chi tiết Sản phẩm</a>
        </c:when>
        <c:otherwise>
            <a href="/login/formdn" class="btn btn-primary">Đăng nhập</a>
        </c:otherwise>
    </c:choose>
</div>
<c:if test="${param.error == 'phai dang nhap'}">
    <div class="alert alert-danger" role="alert">
        Đăng nhập để dùng các chức năng
    </div>
</c:if>
</body>
</html>
