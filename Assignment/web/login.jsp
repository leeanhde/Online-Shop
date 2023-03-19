<%-- 
    Document   : login
    Created on : Mar 18, 2023, 7:38:56 PM
    Author     : anhde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <p class="text-danger">${mess}</p>
            User Name: <input type="text" name="user_name">
            Password: <input type="password" name="password">
            <input type="submit" value="Login" name="login"/>
        </form>

        <form action="signup" method="post">
            User Name:<input type="text" name="user_name">
            Password:<input type="password" name="password">
            Repeat Password: <input type="password" name="repassword">
            <input type="submit" value="Sign Up" name="sign_up"/>
        </form>
    </body>
</html>
