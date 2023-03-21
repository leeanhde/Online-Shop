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


        <jsp:include page="../menu.jsp"></jsp:include>


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
                        <a href="delete?user_id=${u.user_id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="insertuser">Insert</a>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
