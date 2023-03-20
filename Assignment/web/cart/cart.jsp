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
        <style>
            /* Style for ul and li elements */
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
            }

            /* Style for table and td elements */
            table {
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

           
        </style>
    </head>
    <body>
        <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>

            <h1>All Cart Items</h1>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                <c:forEach items="${listC}" var="c" varStatus="loop">
                    <c:if test="${c.user_id == 1}">
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
                                    ${p.price} $
                                </c:if>
                            </c:forEach>
                        </td>
                        
                    </tr>
                    </c:if>
                </c:forEach>
            </tbody>
            <th>Total Price: </th>
        </table>

        <jsp:include page="../footer.jsp"></jsp:include>

    </body>
</html>
