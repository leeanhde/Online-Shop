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

    public User login(String user, String pass) {
        String sql = "SELECT * from [User] WHERE [name] = ? and [password] = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            User u = null;
            while (rs.next()) {
                if (u == null) {
                    u = new User();
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int phone = rs.getInt("phone");
                    int isAdmin = rs.getInt("isAdmin");

                    u.setUser_id(user_id);
                    u.setName(name);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setPhone(phone);
                    u.setIsAdmin(isAdmin);
                }
                return u;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public User check(String user) {
        String sql = "SELECT * from [User] WHERE [name] = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            User u = null;
            while (rs.next()) {
                if (u == null) {
                    u = new User();
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int phone = rs.getInt("phone");
                    int isAdmin = rs.getInt("isAdmin");

                    u.setUser_id(user_id);
                    u.setName(name);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setPhone(phone);
                    u.setIsAdmin(isAdmin);
                }
                return u;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void insert(User model) {
        try {
            String sql = "INSERT INTO [User](user_id, [name], email, [password], phone, isAdmin)\n"
                    + "Values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.setString(2, model.getName());
            stm.setString(3, model.getEmail());
            stm.setString(4, model.getPassword());
            stm.setInt(5, model.getPhone());
            stm.setInt(6, model.getIsAdmin());
            stm.executeUpdate();
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(User model) {
        try {
            String sql = "UPDATE [User] SET  [name] = ? ,[email] = ?,  [password] = ? , [phone] = ?, isAdmin = ? Where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setString(2, model.getEmail());
            stm.setString(3, model.getPassword());
            stm.setInt(4, model.getPhone());
            stm.setInt(5, model.getIsAdmin());
            stm.setInt(6, model.getUser_id());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(User model) {
        try {
            String sql = "DELETE [User] \n"
                    + "WHERE user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User get(int id) {
        try {
            String sql = "SELECT * From [User] Where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            User u = null;
            while (rs.next()) {
                if (u == null) {
                    u = new User();
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int phone = rs.getInt("phone");
                    int isAdmin = rs.getInt("isAdmin");

                    u.setUser_id(user_id);
                    u.setName(name);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setPhone(phone);
                    u.setIsAdmin(isAdmin);
                }
                return u;

            }
        } catch (SQLException e) {
            Logger.getLogger(UserDBContext.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

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
                int isAdmin = rs.getInt("isAdmin");

                u.setUser_id(user_id);
                u.setName(name);
                u.setEmail(email);
                u.setPassword(password);
                u.setPhone(phone);
                u.setIsAdmin(isAdmin);

                users.add(u);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return users;

    }

}
