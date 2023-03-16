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
            String sql = "INSERT INTO [User](user_id, [name], email, [password], phone)\n"
                    + "Values (?, ?, ?, ?, ?)";
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
                    + "WHERE [user_id] = ?";
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
            String sql = "SELECT user_id From [USER] Where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
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
