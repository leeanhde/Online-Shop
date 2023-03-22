<%-- 
    Document   : listuser
    Created on : Mar 6, 2023, 3:31:34 AM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List User</title>
        <script>
            function remove(id)
            {
                var result = confirm("are you sure?");
                if (result)
                    window.location.href = "delete?user_id=" + id;
            }
        </script>
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


        <table border = 1px>
            <td>User ID</td>
            <td>User Name</td>
            <td>Password</td>
            <td>Email</td>
            <td>Phone</td>
            <td></td>
            <td></td>
            <c:forEach items="${requestScope.users}" var="u">
                <tr>
                    <td>${u.user_id}</td>
                    <td>${u.name}</td>
                    <td>${u.password}</td>
                    <td>${u.email}</td>
                    <td>${u.phone}</td>
                    <td>
                        <a href="updateuser?user_id=${u.user_id}">Edit</a>
                    </td>     
                    <td>
                        <a href="#" onclick="remove(${u.user_id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="insertuser">Insert</a>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
