package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    public static final String URL = "jdbc:mariadb://localhost/";
    public static final String DB = "universidadlp";
    public static final String USUARIO = "root";
    public static final String PASSWORD = "";

    private static Connection connection;

    //Constructor
    private Conexion() {
    }

    public static Connection getConexion() {

        if (connection == null) {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" +
"&user=" + USUARIO + "&password=" + PASSWORD);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Problema con el Driver " + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema de Conexion " + ex.getMessage());
            }

        }
        return connection;
    }

}
