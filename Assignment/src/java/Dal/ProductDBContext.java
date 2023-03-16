/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Product;
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
public class ProductDBContext extends DBContext<Product> {

    public ArrayList<Product> search(String search) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String search = "";
            String sql = "SELECT * FROM [Product]\n"
                    + "WHERE product_name like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                
                Product p = new Product();
                p.setProduct_id(rs.getInt("product_id"));
                p.setC_id(rs.getInt("c_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setPrice(rs.getInt("price"));
                p.setDescription(rs.getString("description"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public void insert(Product model) {
        try {
            String sql = "INSERT INTO [Product] (product_id, c_id, product_name, price, [description])\n"
                    + "VALUES (?, ?, ? ,? ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getProduct_id());
            stm.setInt(2, model.getC_id());
            stm.setString(3, model.getProduct_name());
            stm.setInt(4, model.getPrice());
            stm.setString(5, model.getDescription());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Product model) {
        try {
            String sql = "Update [Product] set [product_name] = ? , c_id = ?, price = ?, [description] = ? Where product_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getProduct_name());
            stm.setInt(2, model.getC_id());
            stm.setInt(3, model.getPrice());
            stm.setString(4, model.getDescription());
            stm.setInt(5, model.getProduct_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Product model) {
        try {
            String sql = "DELETE [Product]\n"
                    + "WHERE product_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getProduct_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Product get(int id) {
        try {
            String sql = "SELECT *\n"
                    + "FROM Product \n"
                    + "WHERE product_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Product p = null;
            while (rs.next()) {
                if (p == null) {
                    p = new Product();
                    int product_id = rs.getInt("product_id");
                    String product_name = rs.getString("product_name");
                    int price = rs.getInt("price");
                    String description = rs.getString("description");

                    p.setProduct_id(product_id);
                    p.setC_id(id);
                    p.setProduct_name(product_name);
                    p.setPrice(price);
                    p.setDescription(description);
                }
            }
            return p;
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    @Override
    public ArrayList<Product> list() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT  product_id, c_id, product_name, price, [description] "
                    + "FROM Product";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getInt("product_id"));
                p.setC_id(rs.getInt("c_id"));
                p.setProduct_name(rs.getString("product_name"));
                p.setPrice(rs.getInt("price"));
                p.setDescription(rs.getString("description"));
                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

}
