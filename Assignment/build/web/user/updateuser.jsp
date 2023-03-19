<%-- 
    Document   : updateuser
    Created on : Mar 13, 2023, 4:18:15 PM
    Author     : anhde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
       <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>


            <form action="updateuser" method="post">
                User ID: <input type="text" name="user_id" value="${param.user_id}"><br>
            User Name: <input type="text" name="name"><br>
            Password: <input type="text" name="password"><br>
            Email: <input type="text" name="email"><br>
            Phone: <input type="number" name="phone"><br>
            <input type="submit" name="Save">
        </form>




        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
