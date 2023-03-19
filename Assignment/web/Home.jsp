<%-- 
    Document   : Home
    Created on : Mar 16, 2023, 9:26:37 PM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>

        </style>
    </head>
    <body>
        <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="menu.jsp"></jsp:include>
            </ul>
            <table border = 1px>
                <tr>
                    <td>Product Name</td>
                    <td>Image</td> 
                    <td>Price</td>
                    <td>Description</td>
                    <td></td>
                </tr>
            <c:forEach items="${requestScope.products}" var="p">
                <tr>
                    <td>
                        <a href="detail?product_id=${p.product_id}">${p.product_name}</a>
                    </td>
                    <td>Image</td>
                    <td>${p.price}</td>
                    <td>${p.description}<td>
                    <td>
                        <a href="#">Add to Cart</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <table border = 1px>
            <tr>
                <td>Categories Name</td>
            </tr>
            <c:forEach items="${requestScope.cate}" var="c">
                <tr>
                    <td>
                        <a href="category?c_id=${c.c_id}">${c.c_name}</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
