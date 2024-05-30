package dao;

import java.sql.*;
import java.util.ArrayList;
import model.SaleInvoices;

public class SaleInvoicesDAO {

    private Connection connection;

    public SaleInvoicesDAO() throws SQLException {
        connection = ConexionBD.conectarse();
    }

    public void addSaleInvoice(SaleInvoices saleInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO facturas_venta (id_factura_venta, fecha_factura_venta, id_empleado, id_cliente) " +
                "VALUES (seq_facturas_venta.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM facturas_venta");
            while (rs.next()) {
                int id_invoice = rs.getInt("id_factura_venta");
                Date invoiceDate = rs.getDate("fecha_factura_venta");
                int employeeId = rs.getInt("id_empleado");
                int clientId = rs.getInt("id_cliente");
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
                "UPDATE facturas_venta SET fecha_factura_venta = ?, id_empleado = ?, id_cliente = ? " +
                "WHERE id_factura_venta = ?")) {
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
                "DELETE FROM facturas_venta WHERE id_factura_venta = ?")) {
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
