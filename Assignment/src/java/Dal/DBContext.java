/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhde
 * @param <T>
 */
public abstract class DBContext<T> {
    
    protected Connection connection;
    public DBContext()
    {
        try {
            String user = "anhde";
            String pass = "anhde";
            String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=Database_assignment";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//    private final String serverName = "localhost";
//    private final String dbName = "Database_assignment";
//    private final String portNumber = "1433";
//    private final String userID = "anhde";
//    private final String password = "anhde";
//
//
//    public Connection getConnection() throws Exception {
//        String url = "jdbc:sqlserver:// " + serverName + ":" + portNumber + ";databaseName=" + dbName;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url, userID, password);
//    }
    
    public abstract void insert(T model); //INSERT INTO
    public abstract void update(T model); //UPDATE SET
    public abstract void delete(T model); //DELETE FROM
    public abstract T get(int id); //SELECT * FROM WHERE id =
    public abstract ArrayList<T> list();//SELECT * FROM
    
}
