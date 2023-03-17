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
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
            }

            /* Style for the search box */
            #search-container {
                float: right;
                margin-top: 10px;
            }

            #search-container input[type=text] {
                padding: 6px;
                margin-top: 1px;
                font-size: 17px;
                border: none;
                border-radius: 4px;
            }

            #search-container button {
                float: inherit;
                padding: 6px 10px;
                margin-top: 1px;
                margin-right: 16px;
                background: #ddd;
                font-size: 17px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            #search-container button:hover {
                background: #ccc;
            }
        </style>
    </head>
    <body>

       
        <ul>
            <li><a class="active" href="Home.jsp">Trang Chủ</a></li>
            <li><a href="#">Giỏ Hàng</a></li>
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


    </body>
</html>
