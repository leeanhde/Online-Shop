<%-- 
    Document   : list
    Created on : Feb 23, 2023, 1:42:32 AM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="logo">
            <img src="" alt="background-header">
        </div>

        <table border = 1px>
            <td>Product ID</td>
            <td>Categories ID</td>
            <td>Product Name</td>
            <td>Price</td>
            <td>Description</td>
            <td></td>
            <td></td>
            <c:forEach items="${requestScope.products}" var="p">
                <tr>
                    <td>${p.product_id}</td>
                    <td>${p.c_id}</td>
                    <td>${p.product_name}</td>
                    <td>${p.price}</td>
                    <td>${p.description}</td>
                    <td>
                        <a href="update?product_id=${p.product_id}">Update</a>
                    </td>
                    <td>
                        <a href="delete?product_id=${p.product_id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="insert">Insert</a>
    </body>
</html>
