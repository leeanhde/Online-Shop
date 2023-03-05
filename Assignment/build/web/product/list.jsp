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
        <table border = 1px>
            <td>product id</td>
            <td>product name</td>
            <td>price</td>
            <td>description</td>
            <td></td>
       
            <c:forEach items="${requestScope.products}" var="p">
                <tr>
                    <td>${p.product_id}</td>
                    <td>${p.product_name}</td>
                    <td>${p.price}</td>
                    <td>${p.description}</td>
                    <td>
                        <a href="update?product_id=${p.product_id}">Edit</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
        <a href="insert">Insert</a>
    </body>
</html>
