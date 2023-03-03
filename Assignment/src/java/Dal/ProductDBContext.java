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
    
    public void search(){
        
        try {
            String sql="";
            PreparedStatement stm = connection.prepareStatement(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void insert(Product model) {
        try {
            connection.setAutoCommit(false);
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getProduct_name());
            
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
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getProduct_name());
            
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
                    
                    

                    p.setProduct_id(product_id);
                    p.setProduct_name(product_name);
                    
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
                p.setProduct_id(product_id);
                p.setProduct_name(product_name);              
                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

}
