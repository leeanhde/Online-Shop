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
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        UserDBContext db = new UserDBContext();
        User user = db.get(id);
        ArrayList<User> list = db.list();
        request.setAttribute("users", list);
        request.setAttribute("user", user);
        request.getRequestDispatcher("../user/updateuser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = new User();
        u.setName(request.getParameter("name"));
        u.setPassword(request.getParameter("password"));
        u.setEmail(request.getParameter("email"));
        u.setPhone(Integer.parseInt(request.getParameter("phone")));
        u.setUser_id(Integer.parseInt(request.getParameter("user_id")));

        UserDBContext db = new UserDBContext();
        db.update(u);

        response.sendRedirect("listuser");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
