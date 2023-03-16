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
        User ID: <input type="text" name="user_id"value="${param.user_id}">
        User Name: <input type="text" name="name">
        Password: <input type="text" name="password">
        Email: <input type="text" name="email"><!-- comment -->
        Phone: <input type="number" name="phone">
    </body>
</html>
