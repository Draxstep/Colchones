package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Marcas {
    
    public void insertarDato(int id, String nombreMarca) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO marcas (id_marca, nombre_marca) VALUES (?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, nombreMarca);
        pstmt.executeUpdate();
        System.out.println("Exitoso");
    }
    conexion.close();
}

}
