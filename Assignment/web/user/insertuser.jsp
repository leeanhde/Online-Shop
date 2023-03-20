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
        <style>
            /* Style for ul and li elements */
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

            /* Style for table and td elements */
            table {
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            /* Style for the "Add to Cart" link */
            a[href='#'] {
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 6px 12px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                margin: 4px 2px;
                cursor: pointer;
            }

            a[href='#']:hover {
                background-color: #3e8e41;
            }
        </style>
    </head>
    <body>

        <ul>
            <li>
                <a href="home">Trang Chủ</a>
            </li>
            <jsp:include page="../menu.jsp"></jsp:include>
            </ul>

            <form action="insertuser" method="post">
                User ID: <input type="number" name="user_id"><br>
                User Name: <input type="text" name="name"><br>
                Password: <input type="text" name="password"><br>
                Email: <input type="text" name="email"><br>
                Phone: <input type="number" name="phone"><br>
                Admin: <input type="number" name="isAdmin"><br>
                <input type="submit" value="Save">
            </form>
        <jsp:include page="../footer.jsp"></jsp:include>
    </body>
</html>
