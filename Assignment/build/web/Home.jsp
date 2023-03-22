<%--
Document : Home
Created on : Mar 16, 2023, 9:26:37 PM
Author : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
            }

            table {
                border-collapse: collapse;
                width: 100%;
                margin-top: 20px;
            }

            th, td {
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f0ad4e;
                color: white;
            }

            td a {
                text-decoration: none;
                color: #337ab7;
            }

            td a:hover {
                text-decoration: underline;
            }

            .add {
                display: inline-block;
                padding: 8px 16px;
                font-size: 16px;
                font-weight: bold;
                color: white;
                background-color: #5cb85c;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .add:hover {
                background-color: #4cae4c;
            }
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

    </head>
    <body>
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

            <table>
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Image</th> 
                        <th>Price</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.products}" var="p">
                    <tr>
                        <td>
                            <a href="detail?product_id=${p.product_id}">${p.product_name}</a>
                        </td>
                        <td><img src="img/image7.jpg" alt="" id="img" width="200px"/></td>
                        <td>${p.price} $</td>
                        <td>${p.description}</td>
                        <td>
                            <a href="listcart" class="add">Add to Cart</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <table>
            <thead>
                <tr>
                    <th>Categories Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.cate}" var="c">
                    <tr>
                        <td>
                            <a href="category?c_id=${c.c_id}">${c.c_name}</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
