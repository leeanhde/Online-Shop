/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Cart;
import Model.Product;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anhde
 */
public class CartDBContext extends DBContext<Cart> {

    public ArrayList<Cart> displayAllCarts() {
        ArrayList<Cart> listC = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Cart";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setCart_id(rs.getInt("cart_id"));
                c.setUser_id(rs.getInt("user_id"));
                c.setProduct_id(rs.getInt("product_id"));
                c.setAmount(rs.getInt("amount"));
                listC.add(c);
            }
        } catch (SQLException e) {
            // handle the exception appropriately
        }
        return listC;
    }

    public Cart get(int Id) {
        
        try {
            String sql = "SELECT c.cart_id, c.user_id, c.product_id, c.amount, p.[product_name], p.price \n"
                    + "FROM Cart c JOIN Product p ON c.product_id = p.product_id\n"
                    + "WHERE c.user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Id);
            ResultSet rs = stm.executeQuery();
            Cart c = null;
            while (rs.next()) {
                c = new Cart();
                Product p = new Product();
                c.setCart_id(rs.getInt("cart_id"));
                c.setUser_id(rs.getInt("user_id"));
                c.setProduct_id(rs.getInt("product_id"));
                c.setAmount(rs.getInt("amount"));
                p.setProduct_id(rs.getInt("product_id"));
                p.setC_id(rs.getInt("c_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setPrice(rs.getInt("price"));
                p.setDescription(rs.getString("description"));
            }
            return c;
        } catch (SQLException e) {
        }
        return null;
    }

}
