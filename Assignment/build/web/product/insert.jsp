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
        <style>
            form input[type="number"],
            form input[type="text"] {
                border: 1px solid #ccc;
                padding: 8px;
                font-size: 14px;
                margin-bottom: 10px;
            }

            form input[type="submit"] {
                background-color: #008CBA;
                color: #fff;
                border: none;
                padding: 10px 16px;
                font-size: 16px;
                cursor: pointer;
                border-radius: 4px;
            }
        </style>
    </head>
    <body>

        <ul>
            <li>
                <a href="../Home.jsp">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>
            <form action="insert" method="POST">
                Product ID: <input type="number" name="product_id"><br>
                Categories ID: <input type="number" name="c_id"><br>
                Product Name: <input type="text" name="product_name"><br>
                Price: <input type="number" name="price"><br>
                Description <input type="text" name="description"><br>
                <input type="submit" value="Save">
            </form>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
