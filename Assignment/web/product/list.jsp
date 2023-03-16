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
        <title>List Product</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <table border="1px">
            <tr>
                <td>Product ID</td>
                <td>Product Name</td>
                <td>Category ID</td>
                <td>Category Name</td>
                <td>Price</td>
                <td>Description</td>
                <td></td>
                <td></td> 
            </tr>

            <c:forEach items="${requestScope.products}" var="p">
                <tr>
                    <td>${p.product_id}</td>
                    <td>${p.product_name}</td>
                    <td>${p.c_id}</td>
                    <td>
                        <c:forEach items="${requestScope.cate}" var="c">
                            <c:if test="${c.c_id == p.c_id}">
                                ${c.c_name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${p.price}</td>
                    <td>${p.description}</td>
                    <td>
                        <a href="update?product_id=${p.product_id}">Edit</a>
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
