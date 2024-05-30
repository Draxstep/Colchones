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
                "INSERT INTO pedidos_colchon (id_pedido_colchon, fecha_colchon_pedido, id_empresa_proveedor, id_empleado) " +
                "VALUES (pedidos_colchon_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, mattressOrder.getFecha_colchon_pedido());
            pstmt.setInt(2, mattressOrder.getId_empresa_proveedor());
            pstmt.setInt(3, mattressOrder.getId_empleado());
            pstmt.executeUpdate();

            System.out.println("Pedido de colchon agregado: " + mattressOrder.getFecha_colchon_pedido());
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
                Date orderDate = rs.getDate("fecha_colchon_pedido");
                int supplierId = rs.getInt("id_empresa_proveedor");
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
                "UPDATE pedidos_colchon SET fecha_colchon_pedido = ?, id_empresa_proveedor = ?, id_empleado = ? " +
                "WHERE id_pedido_colchon = ?")) {
            pstmt.setDate(1, updatedOrder.getFecha_colchon_pedido());
            pstmt.setInt(2, updatedOrder.getId_empresa_proveedor());
            pstmt.setInt(3, updatedOrder.getId_empleado());
            pstmt.setInt(4, updatedOrder.getId_pedido_colchon());
            pstmt.executeUpdate();

            System.out.println("Pedido de colchon actualizado");
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

            System.out.println("Pedido de colchon eliminado con ID: " + id_order);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
