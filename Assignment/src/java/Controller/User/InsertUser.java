/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.User;

import Dal.UserDBContext;
import Model.User;
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
public class InsertUser extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDBContext db = new UserDBContext();
        ArrayList<User> list = db.list();
        request.setAttribute("user", list);
        
        request.getRequestDispatcher("../user/insertuser.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = new User();
        
        u.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        u.setName(request.getParameter("name"));
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
        u.setPhone(Integer.parseInt(request.getParameter("phone")));
        u.setIsAdmin(Integer.parseInt(request.getParameter("isAdmin")));
        
        UserDBContext db = new UserDBContext();
        db.insert(u);
        
        response.sendRedirect("listuser");
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
