package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CompanyTypeContact;

public class CompanyTypeContactDao {
    
    public void insertData(int id_supplierCompanyDao, int id_typeContact, String value) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO proveedores_tipos_contactos (id_empresa_proveedor, id_tipo_contacto, valor_contacto) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id_supplierCompanyDao);
        pstmt.setInt(2, id_typeContact);
        pstmt.setString(3, value);
        pstmt.executeUpdate();
    }
    conexion.close();
    }

    public void removeData(int id_typeContact, int id_supplierCompany) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "DELETE FROM proveedores_tipos_contactos WHERE id_empresa_proveedor=" + id_typeContact + " && id_tipo_contacto = " +  id_supplierCompany;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void emptyTable() throws SQLException{
        Connection conexion = ConexionBD.conectarse();
        String sql = "TRUNCATE TABLE proveedores_tipos_contactos";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.execute();
        }
        conexion.close();
    }

    
   
    public void saveToDB(ArrayList<CompanyTypeContact> companyTypeContacts) throws SQLException{
        emptyTable();
        for(int i=0; i<companyTypeContacts.size(); i++){
            insertData(companyTypeContacts.get(i).getid_SupplierCompany(), companyTypeContacts.get(i).getid_typeContact(), companyTypeContacts.get(i).getValue());
        }
    }
}
