package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.SupplierCompany;
import model.TypeContact;

public class ContactDao {
    
    public void insertData(int id, String typeContactName) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO tipos_contactos (id_tipo_contacto, nombre_tipo_contacto) VALUES (?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, typeContactName);
        pstmt.executeUpdate();
    }
    conexion.close();
    }

    public void removeData(int id) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "DELETE FROM tipos_contactos WHERE id_tipo_contacto=" + id ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void editData(int id, int newTypeContactName) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "UPDATE tipos_contactos SET nombre_tipo_contacto="  + newTypeContactName + "WHERE id_tipo_contacto=" + id ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void emptyTable() throws SQLException{
        Connection conexion = ConexionBD.conectarse();
        String sql = "TRUNCATE TABLE tipos_contactos";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.execute();
        }
        conexion.close();
    }
   
    public void saveToDB(ArrayList<TypeContact> contact) throws SQLException{
        emptyTable();
        for(int i=0; i<contact.size(); i++){
            insertData(contact.get(i).getId_typeContact(), contact.get(i).getTypeContact_name());
        }
    }
}
