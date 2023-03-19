<%-- 
    Document   : cart
    Created on : Mar 20, 2023, 12:00:12 AM
    Autdor     : anhde
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>All Cart Items</title>
    </head>
    <body>
        <h1>All Cart Items</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <th>Total Price</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${listC}" var="c" varStatus="loop">
                        <tr>
                            <td>${c.user_id}</td>
                            <td>${c.product_id}</td>
                            <td>
                                <c:forEach items="${requestScope.products}" var="p">
                                    <c:if test="${c.product_id == p.product_id}">
                                        ${p.product_name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${c.amount}</td>
                            <td>
                                <c:forEach items="${requestScope.products}" var="p">
                                    <c:if test="${c.product_id == p.product_id}">
                                        ${p.price}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${totalPrice}</td>
                        </tr>
                    
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
