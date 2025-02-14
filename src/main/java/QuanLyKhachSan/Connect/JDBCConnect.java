package QuanLyKhachSan.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnect {

    // URL, user và password của PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/quanlykhachsan";
    private static final String USER = "postgres";
    private static final String PASSWORD = "huycong123";

    public static Connection getConnection() throws SQLException {
        try {

            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL driver not found.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
