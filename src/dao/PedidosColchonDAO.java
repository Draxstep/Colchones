package dao;

import java.sql.*;
import java.util.ArrayList;
import model.PedidosColchon;

public class PedidosColchonDAO {

    private Connection conexion;

    public PedidosColchonDAO() throws SQLException {
        conexion = ConexionBD.conectarse();
    }

    public void agregarPedidoColchon(PedidosColchon pedidoColchon) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "INSERT INTO pedidos_colchon (id_pedido_colchon, fecha_colchon_pedido, id_empresa_proveedor, id_empleado) " +
                "VALUES (pedidos_colchon_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, pedidoColchon.getFecha_colchon_pedido());
            pstmt.setInt(2, pedidoColchon.getId_empresa_proveedor());
            pstmt.setInt(3, pedidoColchon.getId_empleado());
            pstmt.executeUpdate();

            System.out.println("Pedido de colchon agregado: " + pedidoColchon.getFecha_colchon_pedido());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PedidosColchon> obtenerPedidosColchon() throws SQLException {
        ArrayList<PedidosColchon> lista_pedidos = new ArrayList<>();
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM pedidos_colchon");
            while (rs.next()) {
                int id_pedido_colchon = rs.getInt("id_pedido_colchon");
                Date fecha_colchon_pedido = rs.getDate("fecha_colchon_pedido");
                int id_empresa_proveedor = rs.getInt("id_empresa_proveedor");
                int id_empleado = rs.getInt("id_empleado");
                PedidosColchon pedido = new PedidosColchon(id_pedido_colchon, fecha_colchon_pedido, id_empresa_proveedor, id_empleado);
                lista_pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_pedidos;
    }

    public boolean actualizarPedidoColchon(PedidosColchon pedidoActualizado) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "UPDATE pedidos_colchon SET fecha_colchon_pedido = ?, id_empresa_proveedor = ?, id_empleado = ? " +
                "WHERE id_pedido_colchon = ?")) {
            pstmt.setDate(1, pedidoActualizado.getFecha_colchon_pedido());
            pstmt.setInt(2, pedidoActualizado.getId_empresa_proveedor());
            pstmt.setInt(3, pedidoActualizado.getId_empleado());
            pstmt.setInt(4, pedidoActualizado.getId_pedido_colchon());
            pstmt.executeUpdate();

            System.out.println("Pedido de colchon actualizado");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPedidoColchon(int id_pedido_colchon) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "DELETE FROM pedidos_colchon WHERE id_pedido_colchon = ?")) {
            pstmt.setInt(1, id_pedido_colchon);
            pstmt.executeUpdate();

            System.out.println("Pedido de colchon eliminado con ID: " + id_pedido_colchon);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
