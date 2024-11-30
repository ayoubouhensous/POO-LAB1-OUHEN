package ConnexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignletonConnexionDB {
    public static Connection connection;


    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_database", "root", "");
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
