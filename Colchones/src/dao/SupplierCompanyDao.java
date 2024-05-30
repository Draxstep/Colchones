package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.SupplierCompany;

public class SupplierCompanyDao {
    
    public void insertData(int id_supplierCompany, String supplierCompany_name) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO empresas_proveedores (id_empresa_proveedor, nombre_proveedor) VALUES (?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id_supplierCompany);
        pstmt.setString(2, supplierCompany_name);
        pstmt.executeUpdate();
    }
    conexion.close();
    }

    public void removeData(int id_supplierCompany) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "DELETE FROM empresas_proveedores WHERE id_empresa_proveedor=" + id_supplierCompany ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void editData(int id_supplierCompany, SupplierCompany supplierCompanyObject) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "UPDATE empresas_proveedores SET id_empresa_proveedor="  + supplierCompanyObject.getId_supplierCompany() + ", nombre_proveedor=" + supplierCompanyObject.getsupplier_name();
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void emptyTable() throws SQLException{
        Connection conexion = ConexionBD.conectarse();
        String sql = "TRUNCATE TABLE empresas_proveedores";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.execute();
        }
        conexion.close();
    }


   
    public void saveToDB(ArrayList<SupplierCompany> supplierCompanys) throws SQLException{
        emptyTable();
        for(int i=0; i<supplierCompanys.size(); i++){
            insertData(supplierCompanys.get(i).getId_supplierCompany(), supplierCompanys.get(i).getsupplier_name());
        }
    }
}

