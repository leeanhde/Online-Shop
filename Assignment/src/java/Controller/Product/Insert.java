/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Product;

import Dal.ProductDBContext;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author anhde
 */
public class Insert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDBContext db = new ProductDBContext();
        ArrayList<Product> list = db.list();
        request.setAttribute("products", list);

        request.getRequestDispatcher("../product/insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product p = new Product();
        p.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
        p.setC_id(Integer.parseInt(request.getParameter("c_id")));
        p.setProduct_name(request.getParameter("product_name"));
        p.setPrice(Integer.parseInt(request.getParameter("price")));
        p.setDescription(request.getParameter("description"));

        ProductDBContext db = new ProductDBContext();
        db.insert(p);

        response.sendRedirect("list");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
