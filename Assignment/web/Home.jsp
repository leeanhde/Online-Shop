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
            /* Style for ul and li elements */
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

            /* Style for the "Add to Cart" link */
            add{
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 6px 12px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                margin: 4px 2px;
                cursor: pointer;
            }

            add :hover {
                background-color: #3e8e41;
            }
        </style>
    </head>
    <body>
        
            <jsp:include page="menu.jsp"></jsp:include>
            
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
                    <td><img src="img/image7.jpg" alt="" id="img" width="200px"/></td>
                    <td>${p.price} $</td>
                    <td>${p.description}<td>
                    <td>
                        <a href="listcart" class="add">Add to Cart</a>
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
