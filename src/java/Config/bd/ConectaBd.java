package Config.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBd {

    private static final String URL = "jdbc:mysql://localhost:3306/academico?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    public Connection getConnection() throws SQLException {
        Connection cn = null;
        try {
            Class.forName(DRIVER).newInstance();
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println("Error en la conexion");
        }
        return cn;
    }
}
