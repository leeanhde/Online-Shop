<%-- 
    Document   : update
    Created on : Feb 23, 2023, 1:37:10 AM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <form action="update" method="POST">
                Product ID: <input type="number" name="product_id" value="${param.product_id}"><br>
            Product Name: <input type="text" name="product_name"><br>
            Categories ID:<input type="number" name="c_id"><br>
            Price:  <input type="number" name="price"><br>
            Description: <input type="text" name="description"><br>
            <input type="submit" value="Save">
        </form>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
