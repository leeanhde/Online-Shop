/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhde
 */
public class UserDBContext extends DBContext<User> {

    @Override
    public void insert(User model) {
        try {
            connection.setAutoCommit(false);
            String sql = "Insert into [User]\n"
                    + ", name\n"
                    + ", email\n"
                    + ", password\n"
                    + ", phone)\n"
                    + "values\n"
                    + "(?\n"
                    + ", ?\n"
                    + ", ?\n"
                    + ", ?\n"
                    + ", ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setString(1, model.getEmail());
            stm.setString(3, model.getPassword());
            stm.setInt(4, model.getPhone());
            stm.executeUpdate();
            
            String sql_get_user_id = "SELECT @@IDENTITY as user_id";
            PreparedStatement stm_get_user_id = connection.prepareStatement(sql_get_user_id);
            ResultSet rs = stm_get_user_id.executeQuery();
            if (rs.next()) {
                model.setUser_id(rs.getInt("user_id"));
            }
            connection.commit();
       } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
        public void update(User model) {
        try {
            connection.setAutoCommit(false);
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.executeUpdate();
           
            //success
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(User model) {
        try {
            String sql = "DELETE User\n"
                    + " WHERE [user_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User get(int user_id) {
        try {
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, user_id);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public ArrayList<User> list() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "Select * from [User]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int phone = rs.getInt("phone");

                u.setUser_id(user_id);
                u.setName(name);
                u.setPassword(password);
                u.setEmail(email);
                u.setPhone(phone);

                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;

    }

}
