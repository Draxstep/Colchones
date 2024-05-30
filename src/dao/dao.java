package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dao {
    
    public void insertarDatos(String nombre, int edad) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO tabla (nombre, edad) VALUES (?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setString(1, nombre);
        pstmt.setInt(2, edad);
        pstmt.executeUpdate();
    }
    conexion.close();
}

}
