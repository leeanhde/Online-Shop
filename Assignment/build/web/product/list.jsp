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
            /* Apply a reset to remove any default padding and margin */
            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            /* Apply a clearfix to the body to clear any floated content */
            body::after {
                content: "";
                display: table;
                clear: both;
            }

            /* Style the product table */
            .product-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .product-table th {
                text-align: left;
                background-color: #f2f2f2;
                padding: 10px;
                font-weight: bold;
            }

            .product-table td {
                border: 1px solid #ccc;
                padding: 10px;
            }

            /* Style the edit and delete links */
            .edit-link,
            .delete-link {
                display: inline-block;
                padding: 5px 10px;
                background-color: #ddd;
                color: #333;
                text-decoration: none;
                border-radius: 3px;
                margin-right: 10px;
            }

            /* Style the insert link */
            .insert-link {
                display: inline-block;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                text-decoration: none;
                border-radius: 3px;
                margin-top: 20px;
            }

        </style>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
            <table class="product-table">
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Category ID</th>
                    <th>Category Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th></th>
                    <th></th>
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
                        <a href="update?product_id=${p.product_id}" class="edit-link">Edit</a>
                    </td>
                    <td>
                        <a href="delete?product_id=${p.product_id}" class="delete-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="insert" class="insert-link">Insert</a>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>

</html>
