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
                "INSERT INTO colchones_facturados (id_colchon_facturado, id_factura_venta) " +
                "VALUES (?, ?)")) {
            pstmt.setInt(1, mattressModelInvoice.getMattress_model_id());
            pstmt.setInt(2, mattressModelInvoice.getSale_invoice_id());
            pstmt.executeUpdate();

            System.out.println("Modelo de colchón facturado agregado: " + mattressModelInvoice.getMattress_model_id() + " - " + mattressModelInvoice.getSale_invoice_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MattressModelInvoice> getMattressModelInvoices() throws SQLException {
        ArrayList<MattressModelInvoice> modelList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM colchones_facturados");
            while (rs.next()) {
                int id_model = rs.getInt("id_colchon_facturado");
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
                "UPDATE colchones_facturados SET id_factura_venta = ? " +
                "WHERE id_colchon_facturado = ? AND id_factura_venta = ?")) {
            pstmt.setInt(1, updatedModel.getSale_invoice_id());
            pstmt.setInt(2, updatedModel.getMattress_model_id());
            pstmt.setInt(3, updatedModel.getSale_invoice_id());
            pstmt.executeUpdate();

            System.out.println("Modelo de colchón facturado actualizado");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

