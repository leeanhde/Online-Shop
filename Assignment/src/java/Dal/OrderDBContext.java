/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;
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
public class OrderDBContext extends DBContext<Order> {

    @Override
    public void insert(Order model) {
        String sql = "select * from [Order]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

        } catch (SQLException e) {
        }
    }

    @Override
    public void update(Order model) {
        String sql = "select * from [Order]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(Order model) {
        String sql = "select * from [Order]";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

        } catch (SQLException e) {
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
