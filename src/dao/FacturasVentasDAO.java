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
                "INSERT INTO facturas_ventas (id_factura_venta, fecha_factura_venta, id_empleado, id_cliente) " +
                "VALUES (facturas_ventas_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, saleInvoice.getFecha_factura_venta());
            pstmt.setInt(2, saleInvoice.getId_empleado());
            pstmt.setInt(3, saleInvoice.getId_cliente());
            pstmt.executeUpdate();

            System.out.println("Factura de venta agregada: " + saleInvoice.getFecha_factura_venta());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SaleInvoices> getSaleInvoices() throws SQLException {
        ArrayList<SaleInvoices> invoiceList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM facturas_ventas");
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
                "UPDATE facturas_ventas SET fecha_factura_venta = ?, id_empleado = ?, id_cliente = ? " +
                "WHERE id_factura_venta = ?")) {
            pstmt.setDate(1, updatedInvoice.getFecha_factura_venta());
            pstmt.setInt(2, updatedInvoice.getId_empleado());
            pstmt.setInt(3, updatedInvoice.getId_cliente());
            pstmt.setInt(4, updatedInvoice.getId_factura_venta());
            pstmt.executeUpdate();

            System.out.println("Factura de venta actualizada");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSaleInvoice(int id_invoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "DELETE FROM facturas_ventas WHERE id_factura_venta = ?")) {
            pstmt.setInt(1, id_invoice);
            pstmt.executeUpdate();

            System.out.println("Factura de venta eliminada con ID: " + id_invoice);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

