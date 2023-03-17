/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhde
 */
public class OrderDBContext extends DBContext<Order> {

    @Override
    public void insert(Order model) {
        String sql = "INSERT INTO [Order] (o_id, user_id, [status] , total, create_at) \n"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getO_id());
            stm.setInt(2, model.getUser_id());
            stm.setString(3, model.getStatus());
            stm.setDouble(4, model.getTotal());
            stm.setDate(5, model.getCreate_at());
            stm.executeUpdate();

        } catch (SQLException e) {
        }
    }

    @Override
    public void update(Order model) {
        String sql = "UPDATE [Order] SET user_id = ?, [status] = ?, total = ?, create_at = ? WHERE o_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, model.getUser_id());
            stm.setString(2, model.getStatus());
            stm.setDouble(3, model.getTotal());
            stm.setTimestamp(4, new Timestamp(model.getCreate_at().getTime()));
            stm.setInt(5, model.getO_id());

            // execute the update statement
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(Order model) {
        String sql = "DELETE [Order] WHERE o_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getO_id());
            stm.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Order get(int id) {
        String sql = "select * from [Order] where o_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Order o = null;
            while (rs.next()) {
                if (o == null) {
                    o = new Order();
                    o.setO_id(rs.getInt("o_id"));
                    o.setUser_id(rs.getInt("user_id"));
                    o.setStatus(rs.getString("status"));
                    o.setTotal(rs.getInt("total"));
                    o.setCreate_at(rs.getDate("create_at"));
                }
            }

        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public ArrayList<Order> list() {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "select * from [Order]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setO_id(rs.getInt("o_id"));
                o.setUser_id(rs.getInt("user_id"));
                o.setStatus(rs.getString("status"));
                o.setTotal(rs.getInt("total"));
                o.setCreate_at(rs.getDate("create_at"));

                orders.add(o);
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }

}
