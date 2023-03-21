<%-- 
    Document   : update
    Created on : Feb 23, 2023, 1:37:10 AM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <style>
            a {
                color: red;
            }
            .product-info {
                font-size: 14px;
            }

            #product-name {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="menu.jsp"></jsp:include>
            </ul>
            <form action="update" method="POST">
                Product ID: <input type="number" name="product_id" value="${param.product_id}"><br>
            Product Name: <input type="text" name="product_name"><br>
            Categories ID:<input type="number" name="c_id"><br>
            Price:  <input type="number" name="price"><br>
            Description: <input type="text" name="description"><br>
            <input type="submit" value="Save">
        </form>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
