package dao;

import java.sql.*;
import java.util.ArrayList;
import model.MattressOrders;

public class MattressOrdersDAO {

    private Connection connection;

    public MattressOrdersDAO() throws SQLException {
        connection = ConexionBD.conectarse();
    }

    public void addMattressOrder(MattressOrders mattressOrder) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO pedidos_colchon (id_pedido_colchon, fecha_pedido_colchon, id_proveedor, id_empleado) " +
                "VALUES (seq_pedidos_colchon.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM pedidos_colchon");
            while (rs.next()) {
                int id_order = rs.getInt("id_pedido_colchon");
                Date orderDate = rs.getDate("fecha_pedido_colchon");
                int supplierId = rs.getInt("id_proveedor");
                int employeeId = rs.getInt("id_empleado");
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
                "UPDATE pedidos_colchon SET fecha_pedido_colchon = ?, id_proveedor = ?, id_empleado = ? " +
                "WHERE id_pedido_colchon = ?")) {
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
                "DELETE FROM pedidos_colchon WHERE id_pedido_colchon = ?")) {
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

