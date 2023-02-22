/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Product;
import java.sql.Date;
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

    @Override
    public void insert(Product model) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Product]\n"
                    + "(product_id\n"
                    + ",product_name\n"
                    + ",[status]\n"
                    + ",price_in\n"
                    + ",price_out\n"
                    + ",guarantee)\n"
                    + "VALUES\n"
                    + "(?\n"
                    + ",?\n"
                    + ",?\n"
                    + ",?\n"
                    + ",?\n"
                    + ",?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getProduct_name());
            stm.setString(2, model.getStatus());
            stm.setInt(3, model.getPrice_in());
            stm.setInt(4, model.getPrice_out());
            stm.setDate(5, model.getGuarantee());
            stm.setInt(6, model.getProduct_id());
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
                    + "product_name = ?\n"
                    + ",[status] = ?\n"
                    + ",price_in = ?\n"
                    + ",price_out = ?\n"
                    + ",guarantee = ?\n"
                    + "WHERE [product_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getProduct_name());
            stm.setString(2, model.getStatus());
            stm.setInt(3, model.getPrice_in());
            stm.setInt(4, model.getPrice_out());
            stm.setDate(5, model.getGuarantee());
            stm.setInt(6, model.getProduct_id());
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
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Product p = null;
            while (rs.next()) {
                if (p == null) {
                    p = new Product();
                    int product_id = rs.getInt("product_id");
                    String product_name = rs.getString("product_name");
                    String status = rs.getString("status");
                    int price_in = rs.getInt("price_in");
                    int price_out = rs.getInt("price_out");
                    Date guarantee = rs.getDate("guarantee");

                    p.setProduct_id(product_id);
                    p.setProduct_name(product_name);
                    p.setStatus(status);
                    p.setPrice_in(price_in);
                    p.setPrice_out(price_out);
                    p.setGuarantee(guarantee);
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
        String sql = "SELECT * FROM Product";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String status = rs.getString("status");
                int price_in = rs.getInt("price_in");
                int price_out = rs.getInt("price_out");
                Date guarantee = rs.getDate("guarantee");

                p.setProduct_id(product_id);
                p.setProduct_name(product_name);
                p.setStatus(status);
                p.setPrice_in(price_in);
                p.setPrice_out(price_out);
                p.setGuarantee(guarantee);
                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

}
