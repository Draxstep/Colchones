package dao;

import java.sql.*;
import java.util.ArrayList;
import model.ModelosColchonFactura;

public class ModelosColchonFacturaDAO {

    private Connection conexion;

    public ModelosColchonFacturaDAO() throws SQLException {
        conexion = ConexionBD.conectarse();
    }

    public void agregarModeloColchonFactura(ModelosColchonFactura modeloColchonFactura) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "INSERT INTO modelos_colchon_factura (id_modelo_colchon, id_factura_venta) " +
                "VALUES (?, ?)")) {
            pstmt.setInt(1, modeloColchonFactura.getId_modelo_colchon());
            pstmt.setInt(2, modeloColchonFactura.getId_factura_venta());
            pstmt.executeUpdate();

            System.out.println("Modelo de colchon facturado agregado: " + modeloColchonFactura.getId_modelo_colchon() + " - " + modeloColchonFactura.getId_factura_venta());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ModelosColchonFactura> obtenerModelosColchonFactura() throws SQLException {
        ArrayList<ModelosColchonFactura> lista_modelos = new ArrayList<>();
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM modelos_colchon_factura");
            while (rs.next()) {
                int id_modelo_colchon = rs.getInt("id_modelo_colchon");
                int id_factura_venta = rs.getInt("id_factura_venta");
                ModelosColchonFactura modelo = new ModelosColchonFactura(id_modelo_colchon, id_factura_venta);
                lista_modelos.add(modelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_modelos;
    }

    public boolean actualizarModeloColchonFactura(ModelosColchonFactura modeloActualizado) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "UPDATE modelos_colchon_factura SET id_factura_venta = ? " +
                "WHERE id_modelo_colchon = ? AND id_factura_venta = ?")) {
            pstmt.setInt(1, modeloActualizado.getId_factura_venta());
            pstmt.setInt(2, modeloActualizado.getId_modelo_colchon());
            pstmt.setInt(3, modeloActualizado.getId_factura_venta());
            pstmt.executeUpdate();

            System.out.println("Modelo de colchon facturado actualizado");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarModeloColchonFactura(int id_modelo_colchon, int id_factura_venta) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "DELETE FROM modelos_colchon_factura WHERE id_modelo_colchon = ? AND id_factura_venta = ?")) {
            pstmt.setInt(1, id_modelo_colchon);
            pstmt.setInt(2, id_factura_venta);
            pstmt.executeUpdate();

            System.out.println("Modelo de colchon facturado eliminado con ID: " + id_modelo_colchon + " - " + id_factura_venta);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
