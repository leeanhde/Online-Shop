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
        <style>
            /* Apply a margin to the form and center it horizontally */
            form {
                margin: 0 auto;
                width: 50%;
            }

            /* Style the input fields */
            input[type="number"],
            input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                box-sizing: border-box;
                border: none;
                border-bottom: 2px solid gray;
                outline: none;
            }

            /* Style the submit button */
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            /* Change the color of the button when hovered */
            input[type="submit"]:hover {
                background-color: #3e8e41;
            }

        </style>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
        
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
