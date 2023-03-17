/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order_Detail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anhde
 */
public class OrderDetailDBContext extends DBContext<Order_Detail> {

    @Override
    public void insert(Order_Detail model) {
        String sql = "INSERT INTO Order_Detail (od_id,o_id, product_id, quantity) "
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getOd_id());
            stm.setInt(2, model.getO_id());
            stm.setInt(3, model.getProduct_id());
            stm.setInt(4, model.getQuantyti());
            stm.executeUpdate();
        } catch (SQLException e) {
            
        }
    }

    @Override
    public void update(Order_Detail model) {
        String sql = "UPDATE Order_Detail SET quantity = ?, o_id = ?"
                + "WHERE od_id = ? AND product_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getQuantyti());
            stm.setInt(2, model.getO_id());
            stm.setInt(3, model.getOd_id());
            stm.setInt(4, model.getProduct_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Order_Detail model) {
        String sql = "DELETE FROM Order_Detail WHERE od_id = ? and product_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getOd_id());
            stm.setInt(2, model.getProduct_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order_Detail get(int id) {
        String sql = "SELECT * FROM Order_Detail WHERE od_id = ? AND product_id = ?";
        Order_Detail orderDetail = null;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int od_id = rs.getInt("od_id");
                int o_id = rs.getInt("o_id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                
                orderDetail = new Order_Detail(od_id, o_id, productId, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetail;
    }

    @Override
    public ArrayList<Order_Detail> list() {
        String sql = "SELECT * FROM Order_Detail";
        ArrayList<Order_Detail> orderDetails = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int od_id = rs.getInt("od_id");
                int o_id = rs.getInt("o_id");
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                orderDetails.add(new Order_Detail(od_id, o_id, productId, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
}


