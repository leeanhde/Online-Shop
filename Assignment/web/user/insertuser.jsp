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
        
        <ul>
            <li><a class="active" href="Home.jsp">Trang Chủ</a></li>
            <li><a href="order/listorder.jsp">Giỏ Hàng</a></li>
            <li><a href="#">Liên Hệ</a></li>
            <li><a href="#">Giới Thiệu</a></li>
            <li>
                <div id="search-container">
                    <form action="../product/search">
                        <input type="text" placeholder="Search...">
                        <button type="submit">Search</button>
                    </form>
                </div>
            </li>
        </ul>
        
        <form action="insertuser" method="post">
            User ID: <input type="number" name="user_id"><br>
            User Name: <input type="text" name="name"><br>
            Password: <input type="text" name="password"><br>
            Email: <input type="text" name="email"><br>
            Phone: <input type="number" name="phone"><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
