package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:oracle:thin:@172.19.80.1:1521:orcl";
    private static final String USUARIO = "colchones";
    private static final String CONSTRASENA = "c123";

    public static Connection conectarse() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONSTRASENA);
    }
    
}
