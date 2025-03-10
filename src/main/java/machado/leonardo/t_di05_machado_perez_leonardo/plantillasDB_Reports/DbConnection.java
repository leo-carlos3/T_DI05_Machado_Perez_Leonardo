package machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    final static String url = "jdbc:sqlite:chinook.db";

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e) {}
        // Al informe compilado le cargamos los parametros y la conexión a la base de datos
        try (var conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
