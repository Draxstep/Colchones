package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MattressModels;

public class MattressModelsDao {
    
    public void insertData(int id_mattress_model, String mattress_model_name, int mattress_model_length, int mattress_model_width, int mattress_model_height, String mattress_model_material, int mattress_model_price, int id_brand, int id_mattress_model_type, int id_mattress_warranty) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO modelos_colchon (id_modelo_colchon, nombre_modelo_colchon, largo_modelo_colchon, ancho_modelo_colchon, alto_modelo_colchon, material_modelo_colchon, precio_modelo_colchon, id_marca, id_tipo_modelo_colchon, id_garantia_colchon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id_mattress_model);
        pstmt.setString(2, mattress_model_name);
        pstmt.setInt(3, mattress_model_length);
        pstmt.setInt(4, mattress_model_width);
        pstmt.setInt(5, mattress_model_height);
        pstmt.setString(6, mattress_model_material);
        pstmt.setInt(7, mattress_model_price);
        pstmt.setInt(8, id_brand);
        pstmt.setInt(9, id_mattress_model_type);
        pstmt.setInt(10, id_mattress_warranty);
        pstmt.executeUpdate();
    }
    conexion.close();
    }

    public void removeData(int id_mattress_model) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "DELETE FROM modelos_colchon WHERE id_modelo_colchon=" + id_mattress_model ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void editData(int id_mattress_model, MattressModels mattress_modelObject) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "UPDATE modelos_colchon SET id_modelo_colchon="  + mattress_modelObject.getId_mattress_model() + ", nombre_modelo_colchon=" + mattress_modelObject.getMattress_model_name() +  ", largo_modelo_colchon=" + mattress_modelObject.getMattress_model_length() +  ", ancho_modelo_colchon=" + mattress_modelObject.getMattress_model_width() +  ", alto_modelo_colchon=" + mattress_modelObject.getMattress_model_height() +  ", material_modelo_colchon=" + mattress_modelObject.getMattress_model_material() +  ", precio_modelo_colchon=" + mattress_modelObject.getMattress_model_price() +  ", id_marca=" + mattress_modelObject.getId_brand() +  ", id_tipo_modelo_colchon=" + mattress_modelObject.getId_mattress_model_type() +  ", id_garantia_colchon=" + mattress_modelObject.getId_mattress_warranty() + "WHERE id_garantia=" + id_mattress_model ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void emptyTable() throws SQLException{
        Connection conexion = ConexionBD.conectarse();
        String sql = "TRUNCATE TABLE modelos_colchon";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.execute();
        }
        conexion.close();
    }


   
    public void saveToDB(ArrayList<MattressModels> mattress_models) throws SQLException{
        emptyTable();
        for(int i=0; i<mattress_models.size(); i++){
            insertData(mattress_models.get(i).getId_mattress_model(), mattress_models.get(i).getMattress_model_name(), mattress_models.get(i).getMattress_model_length(), mattress_models.get(i).getMattress_model_width(), mattress_models.get(i).getMattress_model_height(), mattress_models.get(i).getMattress_model_material(), mattress_models.get(i).getMattress_model_price(), mattress_models.get(i).getId_brand(), mattress_models.get(i).getId_mattress_model_type(), mattress_models.get(i).getId_mattress_warranty());
        }
    }
}

