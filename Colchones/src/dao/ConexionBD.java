package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USUARIO = "nicolas";
    private static final String CONSTRASENA = "123";

    public static Connection conectarse() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONSTRASENA);
    }
    
}
