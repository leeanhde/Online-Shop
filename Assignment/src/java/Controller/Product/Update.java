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
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author anhde
 */
public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDBContext db = new ProductDBContext();
        Product p = db.get(id);
        
        
        
        request.getRequestDispatcher("../product/update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product p = new Product();
        p.setProduct_name(request.getParameter("product_name"));
        p.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
        p.setStatus(request.getParameter("status"));
        p.setPrice_in(Integer.parseInt(request.getParameter("price_in")));
        p.setPrice_out(Integer.parseInt(request.getParameter("price_out")));
        p.setGuarantee(Date.valueOf(request.getParameter("guarantee")));
        
        ProductDBContext db  = new ProductDBContext();
        db.update(p);
        
        response.sendRedirect("list");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
