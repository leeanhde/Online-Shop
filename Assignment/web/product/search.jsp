<%-- 
    Document   : search_result
    Created on : Mar 17, 2023, 12:45:51 AM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
        <h1>Search Results</h1>

        <c:if test="${not empty products}">
            
            <table border = 1px>
                <tr>
                    <td>Product ID</td>
                    <td>Product Name</td>
                    <td>Category ID</td>
                    <td>Category Name</td>
                    <td>Price</td>
                    <td>Description</td>
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
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>

</html>
