package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Warranty;

public class WarrantyDao {
    
    public void insertData(int id, int warranty_length) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO garantias (id_garantia, duracion_garantia) VALUES (?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.setInt(2, warranty_length);
        pstmt.executeUpdate();
    }
    conexion.close();
    }

    public void removeData(int id) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "DELETE FROM garantias WHERE id_garantia=" + id ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void editData(int id, int newWarranty_length) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "UPDATE garantias SET duracion_garantia="  + newWarranty_length + "WHERE id_garantia=" + id ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void emptyTable() throws SQLException{
        Connection conexion = ConexionBD.conectarse();
        String sql = "TRUNCATE TABLE garantias";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.execute();
        }
        conexion.close();
    }


   
    public void saveToDB(ArrayList<Warranty> warranty) throws SQLException{
        emptyTable();
        for(int i=0; i<warranty.size(); i++){
            insertData(warranty.get(i).getId_warranty(), warranty.get(i).getWarranty_length());
        }
    }
}
