package currencyconverter.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static Connection conn = null;

    private static final String URL = "jdbc:mariadb://localhost:3306/currency_db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Database Connection Failed: " + e.getMessage());
                throw e;
            }
        }
        return conn;
    }

    public static void terminate() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}