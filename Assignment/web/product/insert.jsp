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
            Product Name: <input type="text" id="name" name="name"><br>
            Status: <input type="text" name="status" id="status"><br>
            Price In: <input type="number" id="in" name="price_in"><br>
            Price Out: <input type="number" name="price_out" id="out"><br>
            Guarantee: <input type="date" name="guarantee" id="guarantee">
            <input type="submit" value="Save">
        </form>
    </body>
</html>
