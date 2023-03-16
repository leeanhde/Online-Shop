<%-- 
    Document   : Home
    Created on : Mar 16, 2023, 9:26:37 PM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <form action="search" method="post">
            <input type="search" name="name">
            <input type="submit" name="Save" value="Search">
        </form>
        
        <table border = 1px>
            <td>Product ID</td>
            <td>Image</td>
            <td>Product Name</td>
            <td>Price</td>
            <td>Description</td>
        </table>
    </body>
</html>
