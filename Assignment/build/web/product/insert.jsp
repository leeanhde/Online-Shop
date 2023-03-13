<%-- 
    Document   : insert
    Created on : Feb 23, 2023, 1:37:33 AM
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
        <form action="insert" method="POST">

            Categories ID: <input type="number" name="c_id"><br>
            Product Name: <input type="text" name="product_name"><br>
            Price: <input type="number" name="price"><br>
            Description <input type="text" name="description"><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
