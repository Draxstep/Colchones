package dao;

import java.sql.*;
import java.util.ArrayList;
import model.MattressModelInvoice;

public class MattressModelInvoiceDAO {

    private Connection connection;

    public MattressModelInvoiceDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void addMattressModelInvoice(MattressModelInvoice mattressModelInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO mattress_model_invoices (mattress_model_id, sale_invoice_id) " +
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM mattress_model_invoices");
            while (rs.next()) {
                int id_model = rs.getInt("mattress_model_id");
                int id_invoice = rs.getInt("sale_invoice_id");
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
                "UPDATE mattress_model_invoices SET sale_invoice_id = ? " +
                "WHERE mattress_model_id = ? AND sale_invoice_id = ?")) {
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

