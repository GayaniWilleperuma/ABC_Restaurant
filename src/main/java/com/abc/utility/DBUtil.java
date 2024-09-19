package com.abc.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String link = "jdbc:mysql://localhost:3306/abc_resturant";
    private static final String username = "root";
    private static final String password = "Gayu@96#";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(link, username, password);
}
}