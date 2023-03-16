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
    
    public void searchUser(User model){
        try {
            String sql = "SELECT * FROM [Product]\n"
                    + "WHERE product_name like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void insert(User model) {
        try {
            String sql = "INSERT INTO [User](user_id, [name], email, [password], phone)\n"
                    + "Values (?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.setString(2, model.getName());
            stm.setString(3, model.getEmail());
            stm.setString(4, model.getPassword());
            stm.setInt(5, model.getPhone());
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User model) {
        try {
            String sql = "UPDATE [User] SET  [name] = ? ,[email] = ?,  [password] = ? , [phone] = ? Where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setString(2, model.getEmail());
            stm.setString(3, model.getPassword());
            stm.setInt(4, model.getPhone());
            stm.setInt(5, model.getUser_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User model) {
        try {
            String sql = "DELETE [User] \n"
                    + "WHERE user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
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

                    u.setUser_id(user_id);
                    u.setName(name);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setPhone(phone);
                }
                return u;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, e);
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
