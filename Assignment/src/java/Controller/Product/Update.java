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


/**
 *
 * @author anhde
 */
public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("product_id"));
        ProductDBContext db = new ProductDBContext();
        Product p = db.get(id);
        request.setAttribute("products", p);
        request.getRequestDispatcher("../product/update.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product p = new Product();
        p.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
        p.setProduct_name(request.getParameter("product_name"));
        p.setC_id(Integer.parseInt(request.getParameter("c_id")));
        p.setPrice(Integer.parseInt(request.getParameter("price")));
        p.setDescription(request.getParameter("description"));
        
        ProductDBContext db  = new ProductDBContext();
        db.update(p);
        response.sendRedirect("list");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
