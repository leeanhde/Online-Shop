/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anhde
 */
public class CategoriesDBContext extends DBContext<Categories> {
    
    public ArrayList<Categories> list() {
        ArrayList<Categories> cate = new ArrayList<>();
        try {
            String sql = "select c_id, c_name from Categories";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Categories c = new Categories();
                c.setC_id(rs.getInt("c_id"));
                c.setC_name(rs.getString("c_name"));
                cate.add(c);
            }
        } catch (SQLException e) {
        }
        return cate;
    }
    
}
