package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MattressModelsOrder;

public class MattressModelsOrderDao {
    
    public void insertData(int id_mattress_model, int id_order) throws SQLException {
    Connection conexion = ConexionBD.conectarse();
    String sql = "INSERT INTO modelos_colchon_pedido (id_modelo_colchon, id_pedido) VALUES (?, ?)";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setInt(1, id_mattress_model);
        pstmt.setInt(2, id_order);
        pstmt.executeUpdate();
    }
    conexion.close();
    }

    public void removeData(int id_order) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "DELETE FROM modelos_colchon_pedido WHERE id_pedido=" + id_order ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }
    
    public void editData(int currentMattres_model_id,  int currentOrder_id, int newMattres_model_id, int newOrder_id) throws SQLException {
        Connection conexion = ConexionBD.conectarse();
        String sql = "UPDATE modelos_colchon_pedido SET id_modelo_colchon="  + newMattres_model_id + ", id_pedido=" + newOrder_id + "WHERE id_modelo_colchon=" + currentMattres_model_id + "AND id_pedido=" + currentOrder_id ;
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.executeQuery();
        }
        conexion.close();
    }

    public void emptyTable() throws SQLException{
        Connection conexion = ConexionBD.conectarse();
        String sql = "TRUNCATE TABLE modelos_colchon_pedido";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.execute();
        }
        conexion.close();
    }


   
    public void saveToDB(ArrayList<MattressModelsOrder> orders) throws SQLException{
        emptyTable();
        for(int i=0; i<orders.size(); i++){
            insertData(orders.get(i).getId_mattress_model(), orders.get(i).getId_order());
        }
    }
}
