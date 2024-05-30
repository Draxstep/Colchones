package dao;

import java.sql.*;
import java.util.ArrayList;
import model.MattressOrders;

public class MattressOrdersDAO {

    private Connection connection;

    public MattressOrdersDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void addMattressOrder(MattressOrders mattressOrder) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO mattress_orders (mattress_order_id, mattress_order_date, supplier_id, employee_id) " +
                "VALUES (mattress_orders_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, mattressOrder.getMattress_order_date());
            pstmt.setInt(2, mattressOrder.getSupplier_id());
            pstmt.setInt(3, mattressOrder.getEmployee_id());
            pstmt.executeUpdate();

            System.out.println("Pedido de colchón agregado: " + mattressOrder.getMattress_order_date());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MattressOrders> getMattressOrders() throws SQLException {
        ArrayList<MattressOrders> orderList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM mattress_orders");
            while (rs.next()) {
                int id_order = rs.getInt("mattress_order_id");
                Date orderDate = rs.getDate("mattress_order_date");
                int supplierId = rs.getInt("supplier_id");
                int employeeId = rs.getInt("employee_id");
                MattressOrders order = new MattressOrders(id_order, orderDate, supplierId, employeeId);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public boolean updateMattressOrder(MattressOrders updatedOrder) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE mattress_orders SET mattress_order_date = ?, supplier_id = ?, employee_id = ? " +
                "WHERE mattress_order_id = ?")) {
            pstmt.setDate(1, updatedOrder.getMattress_order_date());
            pstmt.setInt(2, updatedOrder.getSupplier_id());
            pstmt.setInt(3, updatedOrder.getEmployee_id());
            pstmt.setInt(4, updatedOrder.getMattress_order_id());
            pstmt.executeUpdate();

            System.out.println("Pedido de colchón actualizado");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMattressOrder(int id_order) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "DELETE FROM mattress_orders WHERE mattress_order_id = ?")) {
            pstmt.setInt(1, id_order);
            pstmt.executeUpdate();

            System.out.println("Pedido de colchón eliminado con ID: " + id_order);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
