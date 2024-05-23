package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Tipos_Modelos_Colchon {
    
    private ArrayList<model.Tipos_Modelos_Colchon> lista_tiposModelosColchon;
    private Connection conexion;

    public Tipos_Modelos_Colchon() throws SQLException {
        lista_tiposModelosColchon = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarTipoModeloColchon(model.Tipos_Modelos_Colchon tipoModeloColchon) {

        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO tipos_modelo_colchon (nombre_tipo_colchon, descripcion_tipo_colchon) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, tipoModeloColchon.getNombre_tipo_colchon());
            pstmt.setString(2, tipoModeloColchon.getDescripcion_tipo_modelo());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tipoModeloColchon.setId_tipo_modelo_colchon(generatedKeys.getInt(1));
                }
            }

            System.out.println("Tipo modelo colchon agregado: " + tipoModeloColchon.getNombre_tipo_colchon());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<model.Tipos_Modelos_Colchon> obtenerTipoModeloColchon() throws SQLException {
        
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM tipos_modelo_colchon");
            while (rs.next()) {
                int id_tipo_modelo_colchon = rs.getInt("id_tipo_modelo_colchon");
                String nombre_tipo_colchon = rs.getString("nombre_tipo_colchon");
                String descripcion_tipo_modelo = rs.getString("descripcion_tipo_modelo");
                model.Tipos_Modelos_Colchon tipoModeloColchon = new model.Tipos_Modelos_Colchon(id_tipo_modelo_colchon, nombre_tipo_colchon, descripcion_tipo_modelo);
                lista_tiposModelosColchon.add(tipoModeloColchon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_tiposModelosColchon;
    }

    public boolean actualizarTipoModeloColchon(model.Tipos_Modelos_Colchon tipoModeloColchonActualizado) {
        try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE tipos_modelo_colchon SET nombre_tipo_colchon = ?, descripcion_tipo_modelo = ? WHERE id_tipo_modelo_colchon = ?")) {
            pstmt.setString(1, tipoModeloColchonActualizado.getNombre_tipo_colchon());
            pstmt.setString(2, tipoModeloColchonActualizado.getDescripcion_tipo_modelo());
            pstmt.setInt(3, tipoModeloColchonActualizado.getId_tipo_modelo_colchon());
            pstmt.executeUpdate();

            System.out.println("Modificado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarTipoModeloColchon(int id_tipo_modelo_colchon) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM tipos_modelo_colchon WHERE id_tipo_modelo_colchon = ?")) {
            pstmt.setInt(1, id_tipo_modelo_colchon);
            pstmt.executeUpdate();

            System.out.println("Tipo Modelo Colchon eliminado con ID: " + id_tipo_modelo_colchon);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
