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
            #menu {
                background-color: #333;
                color: #fff;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px;
            }

            #menu ul {
                display: flex;
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            #menu li {
                margin-right: 10px;
            }

            #menu a {
                color: #fff;
                text-decoration: none;
                padding: 5px;
                border-radius: 5px;
            }

            #menu a:hover {
                background-color: #555;
            }

        </style>
    </head>
    <body>
        <div id="menu">
            <ul>
                <li>
                    <a href="../home">Trang Chủ</a>
                </li>
                <li><a href="../listcart">Giỏ Hàng</a></li>
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li><a href="../product/list">Quản lý Sản phẩm</a></li>
                </c:if>

                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li><a href="../user/listuser">Quản lý Nhân viên</a></li>
                </c:if>

                <c:if test="${sessionScope.acc != null}">
                    <li><a href="#">Hello ${sessionScope.acc.name}</a></li>

                </c:if>
                <li>
                    <div id="search-container">
                        <form action="search">
                            <input type="text" placeholder="Search..." name="name" value="${name}">
                            <button type="submit">Search</button>
                        </form>
                    </div>
                </li>
            </ul>
        </div>

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
