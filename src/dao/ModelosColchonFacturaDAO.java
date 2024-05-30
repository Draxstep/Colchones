package dao;

import java.sql.*;
import java.util.ArrayList;
import model.MattressModelInvoice;

public class MattressModelInvoiceDAO {

    private Connection connection;

    public MattressModelInvoiceDAO() throws SQLException {
        connection = ConexionBD.conectarse();
    }

    public void addMattressModelInvoice(MattressModelInvoice mattressModelInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO modelos_colchon_factura (id_modelo_colchon, id_factura_venta) " +
                "VALUES (?, ?)")) {
            pstmt.setInt(1, mattressModelInvoice.getId_modelo_colchon());
            pstmt.setInt(2, mattressModelInvoice.getId_factura_venta());
            pstmt.executeUpdate();

            System.out.println("Modelo de colchon facturado agregado: " + mattressModelInvoice.getId_modelo_colchon() + " - " + mattressModelInvoice.getId_factura_venta());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MattressModelInvoice> getMattressModelInvoices() throws SQLException {
        ArrayList<MattressModelInvoice> modelList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM modelos_colchon_factura");
            while (rs.next()) {
                int id_model = rs.getInt("id_modelo_colchon");
                int id_invoice = rs.getInt("id_factura_venta");
                MattressModelInvoice model = new MattressModelInvoice(id_model, id_invoice);
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    public boolean updateMattressModelInvoice(MattressModelInvoice updatedModel) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE modelos_colchon_factura SET id_factura_venta = ? " +
                "WHERE id_modelo_colchon = ? AND id_factura_venta = ?")) {
            pstmt.setInt(1, updatedModel.getId_factura_venta());
            pstmt.setInt(2, updatedModel.getId_modelo_colchon());
            pstmt.setInt(3, updatedModel.getId_factura_venta());
            pstmt.executeUpdate();

            System.out.println("Modelo de colchon facturado actualizado");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMattressModelInvoice(int id_model, int id_invoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "DELETE FROM modelos_colchon_factura WHERE id_modelo_colchon = ? AND id_factura_venta = ?")) {
            pstmt.setInt(1, id_model);
            pstmt.setInt(2, id_invoice);
            pstmt.executeUpdate();

            System.out.println("Modelo de colchon facturado eliminado con ID: " + id_model + " - " + id_invoice);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
