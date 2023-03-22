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
        <script>
            function remove(id)
            {
                var result = confirm("Are you sure?");
                if (result)
                    window.location.href = "delete?product_id=" + id;
            }
        </script>
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
            #menu {
                background-color: #333;
                color: #fff;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px;
            }

            #menu ul {
                display: flex;
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            #menu li {
                margin-right: 10px;
            }

            #menu a {
                color: #fff;
                text-decoration: none;
                padding: 5px;
                border-radius: 5px;
            }

            #menu a:hover {
                background-color: #555;
            }
        </style>
    </head>
    <body>
        <div id="menu">
            <ul>
                <li>
                    <a href="../home">Trang Chủ</a>
                </li>
                <li><a href="../listcart">Giỏ Hàng</a></li>
                    <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li><a href="../product/list">Quản lý Sản phẩm</a></li>
                    </c:if>

                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li><a href="../user/listuser">Quản lý Nhân viên</a></li>
                    </c:if>

                <c:if test="${sessionScope.acc != null}">
                    <li><a href="#">Hello ${sessionScope.acc.name}</a></li>

                </c:if>
                <li>
                    <div id="search-container">
                        <form action="search">
                            <input type="text" placeholder="Search..." name="name" value="${name}">
                            <button type="submit">Search</button>
                        </form>
                    </div>
                </li>
            </ul>
        </div>

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
                        <a href="#" onclick="remove(${p.product_id})" class="delete-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="insert" class="insert-link">Insert</a>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>

</html>
