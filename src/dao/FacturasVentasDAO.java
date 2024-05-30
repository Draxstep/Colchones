package dao;

import java.sql.*;
import java.util.ArrayList;
import model.SaleInvoices;

public class SaleInvoicesDAO {

    private Connection connection;

    public SaleInvoicesDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void addSaleInvoice(SaleInvoices saleInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO sale_invoices (id_sale_invoice, sale_invoice_date, employee_id, client_id) " +
                "VALUES (sale_invoices_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, saleInvoice.getSale_invoice_date());
            pstmt.setInt(2, saleInvoice.getEmployee_id());
            pstmt.setInt(3, saleInvoice.getClient_id());
            pstmt.executeUpdate();

            System.out.println("Venta agregada: " + saleInvoice.getSale_invoice_date());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SaleInvoices> getSaleInvoices() throws SQLException {
        ArrayList<SaleInvoices> invoiceList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM sale_invoices");
            while (rs.next()) {
                int id_invoice = rs.getInt("id_sale_invoice");
                Date invoiceDate = rs.getDate("sale_invoice_date");
                int employeeId = rs.getInt("employee_id");
                int clientId = rs.getInt("client_id");
                SaleInvoices invoice = new SaleInvoices(id_invoice, invoiceDate, employeeId, clientId);
                invoiceList.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceList;
    }

    public boolean updateSaleInvoice(SaleInvoices updatedInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE sale_invoices SET sale_invoice_date = ?, employee_id = ?, client_id = ? " +
                "WHERE id_sale_invoice = ?")) {
            pstmt.setDate(1, updatedInvoice.getSale_invoice_date());
            pstmt.setInt(2, updatedInvoice.getEmployee_id());
            pstmt.setInt(3, updatedInvoice.getClient_id());
            pstmt.setInt(4, updatedInvoice.getId_sale_invoice());
            pstmt.executeUpdate();

            System.out.println("Venta actualizada");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSaleInvoice(int id_invoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "DELETE FROM sale_invoices WHERE id_sale_invoice = ?")) {
            pstmt.setInt(1, id_invoice);
            pstmt.executeUpdate();

            System.out.println("Venta eliminada con ID: " + id_invoice);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
