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
        <style>
            form {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                margin-top: 50px;
            }

            input[type="text"],
            input[type="password"] {
                padding: 10px;
                margin-bottom: 10px;
                border-radius: 5px;
                border: 1px solid #ccc;
                width: 100%;
                max-width: 300px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
                max-width: 300px;
            }

            p.text-danger {
                color: red;
            }
        </style>
    </head>
    <body>

        <form action="login" method="post">
            <p class="text-danger">${mess}</p>
            User Name: <input type="text" name="user_name">
            Password: <input type="password" name="password">
            <input type="submit" value="Login" name="login"/>
        </form>
    </body>
</html>
