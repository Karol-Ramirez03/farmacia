package com.farmacia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static final String url = "jdbc:mysql://localhost:3306/farmacia2";
    private static final String user = "root";
    private static final String password = "Kr03";

    public static Connection getConnection() throws SQLException  {
        return DriverManager.getConnection(url, user, password);
    }


}
