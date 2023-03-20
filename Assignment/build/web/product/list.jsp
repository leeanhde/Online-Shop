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

            /* Style for the "Add to Cart" link */
            a[href='#'] {
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

            a[href='#']:hover {
                background-color: #3e8e41;
            }
        </style>
    </head>
    <body>
        <ul>
            <li>
                <a href="../Home.jsp">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>

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
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
