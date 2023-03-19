<%-- 
    Document   : insertuser
    Created on : Mar 13, 2023, 4:18:58 PM
    Author     : anhde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        
        <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>
        
        <form action="insertuser" method="post">
            User ID: <input type="number" name="user_id"><br>
            User Name: <input type="text" name="name"><br>
            Password: <input type="text" name="password"><br>
            Email: <input type="text" name="email"><br>
            Phone: <input type="number" name="phone"><br>
            Admin: <input type="number" name="isAdmin"><br>
            <input type="submit" value="Save">
        </form>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
