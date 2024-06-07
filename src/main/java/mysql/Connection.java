package mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public java.sql.Connection DB검색() {
        String url = "jdbc:mysql://127.0.0.1:3306/my_database";

        String username = "root";
        String password = "1234";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
