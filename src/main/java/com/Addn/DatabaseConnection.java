package com.Addn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  

public class DatabaseConnection {
    protected static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String Driver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String Name = "ecommerce";
        String Username = "root";
        String Password = "Naveen@1750";
  
        Class.forName(Driver);
        Connection conn = DriverManager.getConnection(URL + Name,Username,Password);
        return conn;
    }
}