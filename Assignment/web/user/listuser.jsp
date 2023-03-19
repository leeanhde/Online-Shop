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
    </head>
    <body>

        <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>

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
