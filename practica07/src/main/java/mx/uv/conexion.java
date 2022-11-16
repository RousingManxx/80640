package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static String url = "jdbc:mysql://localhost:3306/pruebaBD";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "T7vivs4o";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(DriverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");
        }
        return connection;
    }
}
