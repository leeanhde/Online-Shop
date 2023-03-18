<%-- 
    Document   : search-result
    Created on : Mar 18, 2023, 12:27:05 PM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <ul>
            <li><a class="active" href="Home.jsp">Trang Chủ</a></li>
            <li><a href="order/listorder.jsp">Giỏ Hàng</a></li>
            <li><a href="#">Liên Hệ</a></li>
            <li><a href="#">Giới Thiệu</a></li>
            <li>
                <div id="search-container">
                    <form action="../product/search">
                        <input type="text" placeholder="Search...">
                        <button type="submit">Search</button>
                    </form>
                </div>
            </li>
        </ul>
        
        <table border = 1px>
            <td>User ID</td>
            <td>User Name</td>
            <td>Password</td>
            <td>Email</td>
            <td>Phone</td>
            
            <c:forEach items="${requestScope.userlist}" var="u">
                <tr>
                    <td>${u.user_id}</td>
                    <td>${u.name}</td>
                    <td>${u.password}</td>
                    <td>${u.email}</td>
                    <td>${u.phone}</td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
