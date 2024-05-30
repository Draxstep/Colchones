package dao;

import java.sql.*;
import java.util.ArrayList;
import model.SalesInvoices;

public class SalesInvoicesDAO {

    private Connection connection;

    public SalesInvoicesDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void addSalesInvoice(SalesInvoices salesInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO sales_invoices (id_sales_invoice, sales_invoice_date, employee_id, customer_id) " +
                "VALUES (sales_invoices_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, salesInvoice.getSalesInvoiceDate());
            pstmt.setInt(2, salesInvoice.getEmployeeId());
            pstmt.setInt(3, salesInvoice.getCustomerId());
            pstmt.executeUpdate();

            System.out.println("Sales invoice added: " + salesInvoice.getSalesInvoiceDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SalesInvoices> getSalesInvoices() throws SQLException {
        ArrayList<SalesInvoices> invoiceList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM sales_invoices");
            while (rs.next()) {
                int id_sales_invoice = rs.getInt("id_sales_invoice");
                Date sales_invoice_date = rs.getDate("sales_invoice_date");
                int employee_id = rs.getInt("employee_id");
                int customer_id = rs.getInt("customer_id");
                SalesInvoices invoice = new SalesInvoices(id_sales_invoice, sales_invoice_date, employee_id, customer_id);
                invoiceList.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceList;
    }

    public boolean updateSalesInvoice(SalesInvoices updatedInvoice) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE sales_invoices SET sales_invoice_date = ?, employee_id = ?, customer_id = ? " +
                "WHERE id_sales_invoice = ?")) {
            pstmt.setDate(1, updatedInvoice.getSalesInvoiceDate());
            pstmt.setInt(2, updatedInvoice.getEmployeeId());
            pstmt.setInt(3, updatedInvoice.getCustomerId());
            pstmt.setInt(4, updatedInvoice.getIdSalesInvoice());
            pstmt.executeUpdate();

            System.out.println("Sales invoice updated");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
