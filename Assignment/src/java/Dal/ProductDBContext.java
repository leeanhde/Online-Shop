/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Categories;
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

    public void search(Product model) {

        try {
            connection.setAutoCommit(false);
            String sql = "Select product_id, product_name, price, [description] from [Product]\n"
                    + "where product_name like '%?%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getProduct_name());
            stm.executeQuery();
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void insert(Product model) {
        try {
            connection.setAutoCommit(false);
            String sql = "Insert into Product(product_id, c_id, product_name, price, [description])\n"
                    + "Values('?', '?', '?', '?', '?')";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getProduct_id());
            stm.setInt(2, model.getC_id());
            stm.setString(3, model.getProduct_name());
            stm.setInt(4, model.getPrice());
            stm.setString(5, model.getDescription());
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e1);
            }
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Product model) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Product] \n"
                    + "SET \n"
                    + "[product_id] = ?,\n"
                    + "[product_name] = ?,\n"
                    + "[c_id] = ?,\n"
                    + "[price] = ?,\n"
                    + "[description] = ?,\n"
                    + "WHERE [product_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getProduct_id());
            stm.setString(2, model.getProduct_name());
            stm.setInt(3, model.getC_id());
            stm.setInt(4, model.getPrice());
            stm.setString(5, model.getDescription());
            stm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e1);
            }
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            String sql = "SELECT  product_id,product_name, price, [description]\n"
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

                    Categories c = new Categories();
                    c.setC_id(id);
                    c.setC_name(product_name);
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
        String sql = "SELECT  product_id, c_id, product_name, price, [description] FROM Product";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                int product_id = rs.getInt("product_id");
                int c_id = rs.getInt("c_id");
                String product_name = rs.getString("product_name");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                p.setProduct_id(product_id);
                p.setC_id(c_id);
                p.setProduct_name(product_name);
                p.setPrice(price);
                p.setDescription(description);
                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

}
