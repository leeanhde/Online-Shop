<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul>
    <li><a href="Home.jsp">Trang Chủ</a></li>
    <li><a href="#">Giỏ Hàng</a></li>
    <li><a href="#">Liên Hệ</a></li>
    <li><a href="#">Giới Thiệu</a></li>
     <c:if test="${sessionScope.acc.isAdmin == 1}">
        <li>
            <a href="product/list">Quản lý Sản phẩm</a>
        </li>
        <li>
            <a href="#">Quản lý đơn hàng</a>
        </li>
    </c:if>

    <c:if test="${sessionScope.acc != null}">
        <li>
            <a href="#">Hello ${sessionScope.acc.name}</a>
        </li>
        <li>
            <a href="logout">Đăng xuất</a>
        </li>
    </c:if>


    <c:if test="${sessionScope.acc == null}">
        <li>
            <a href="login.jsp">Đăng Nhập</a>
        </li>
    </c:if>

    <li>
        <div id="search-container">
            <form action="search">
                <input type="text" placeholder="Search..." name="name" value="${name}">
                <button type="submit">Search</button>
            </form>
        </div>
    </li>
</ul>