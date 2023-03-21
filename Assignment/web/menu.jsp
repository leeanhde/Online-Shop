<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    #menu {
        background-color: #333;
        color: #fff;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px;
    }

    #menu ul {
        display: flex;
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    #menu li {
        margin-right: 10px;
    }

    #menu a {
        color: #fff;
        text-decoration: none;
        padding: 5px;
        border-radius: 5px;
    }

    #menu a:hover {
        background-color: #555;
    }
</style>

<div id="menu">
    <ul>
        <li>
            <a href="home">Trang Chủ</a>
        </li>
        <li><a href="listcart">Giỏ Hàng</a></li>
            <c:if test="${sessionScope.acc.isAdmin == 1}">
            <li><a href="product/list">Quản lý Sản phẩm</a></li>
            </c:if>

        <c:if test="${sessionScope.acc.isAdmin == 1}">
            <li><a href="user/listuser">Quản lý Nhân viên</a></li>
            </c:if>

        <c:if test="${sessionScope.acc != null}">
            <li><a href="#">Hello ${sessionScope.acc.name}</a></li>
            <li><a href="logout">Đăng xuất</a></li>
            </c:if>

        <c:if test="${sessionScope.acc == null}">
            <li><a href="login.jsp">Đăng Nhập</a></li>
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
</div>