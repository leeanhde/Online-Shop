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
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>

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
                        <td>Image</td>
                        <td>${detail.price}</td>
                        <td>${detail.description}<td>
                        <td>
                            <a href="#">Add to Cart</a>
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

    </body>

</html>