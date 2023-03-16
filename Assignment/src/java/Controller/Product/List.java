/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Product;

import Dal.CategoriesDBContext;
import Dal.ProductDBContext;
import Model.Categories;
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
public class List extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDBContext db = new ProductDBContext();
        ArrayList<Product> list = db.list();
        CategoriesDBContext caDB = new CategoriesDBContext();
        ArrayList<Categories> calist = caDB.list();
        request.setAttribute("cate", calist);
        request.setAttribute("products", list);
        request.getRequestDispatcher("../product/list.jsp").forward(request, response);
    }
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
