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
        <title>List</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Product ID</td>
                <td>Product Name</td>
                <td>Status</td>
                <td>Price In</td>
                <td>Price Out</td>
                <td>Guarantee</td>
                <td></td>
            </tr>
            <c:forEach items="${requestScope.product}" var="p">
                <tr>
                    <td>${p.product_id}</td>
                    <td>${p.product_name}</td>
                    <td>${p.status}</td>
                    <td>${p.price_in}</td>
                    <td>${p.price_out}</td>
                    <td>${p.guarantee}</td>
                    <td>
                        <a href="update?id=${p.id}">Edit</a>
                    </td>
                    <td>
                        <a href="#" onclick="removeStudent(${s.id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="insert.jsp">Insert</a>
    </body>
</html>
