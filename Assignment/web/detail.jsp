<%-- 
    Document   : search_result
    Created on : Mar 17, 2023, 12:45:51 AM
    Author     : anhde
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Product</title>
        <style>
            /* Style for ul and li elements */

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
            add{
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

            add:hover {
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
                    <a href="home">Trang Chủ</a>
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
                    <li><a href="logout">Đăng xuất</a></li>
                    </c:if>

                <c:if test="${sessionScope.acc == null}">
                    <li><a href="login.jsp">Đăng Nhập</a></li>
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


        <table border = 1px>
            <div>
                <tr>
                    <td>Product Name</td>
                    <td>Image</td> 
                    <td>Price</td>
                    <td>Description</td>
                    <td></td>
                </tr>

                <tr>
                    <td>${detail.product_name}</td>
                    <td>
                        <img src="img/image7.jpg" alt="" width= "200px"/>
                    </td>
                    <td>${detail.price}</td>
                    <td>${detail.description}<td>
                    <td>
                        <a href="listcart">Add to Cart</a>
                    </td>
                </tr>

            </div>
        </table>
        <table border = 1px>
            <div>
                <tr>
                    <td>Categories Name</td>
                </tr>
                <c:forEach items="${requestScope.cate}" var="c">
                    <tr>
                        <td>
                            <a href="category?c_id=${c.c_id}">${c.c_name}</a>
                        </td>
                    </tr>
                </c:forEach>
            </div>
        </table>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>
