package dao;

import java.sql.*;
import java.util.ArrayList;
import model.FacturasVentas;

public class FacturasVentasDAO {

    private Connection conexion;

    public FacturasVentasDAO() throws SQLException {
        conexion = ConexionBD.conectarse();
    }

    public void agregarFacturaVenta(FacturasVentas facturaVenta) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "INSERT INTO facturas_ventas (id_factura_venta, fecha_factura_venta, id_empleado, id_cliente) " +
                "VALUES (facturas_ventas_seq.NEXTVAL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, facturaVenta.getFecha_factura_venta());
            pstmt.setInt(2, facturaVenta.getId_empleado());
            pstmt.setInt(3, facturaVenta.getId_cliente());
            pstmt.executeUpdate();

            System.out.println("Factura de venta agregada: " + facturaVenta.getFecha_factura_venta());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FacturasVentas> obtenerFacturasVentas() throws SQLException {
        ArrayList<FacturasVentas> lista_facturas = new ArrayList<>();
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM facturas_ventas");
            while (rs.next()) {
                int id_factura_venta = rs.getInt("id_factura_venta");
                Date fecha_factura_venta = rs.getDate("fecha_factura_venta");
                int id_empleado = rs.getInt("id_empleado");
                int id_cliente = rs.getInt("id_cliente");
                FacturasVentas factura = new FacturasVentas(id_factura_venta, fecha_factura_venta, id_empleado, id_cliente);
                lista_facturas.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_facturas;
    }

    public boolean actualizarFacturaVenta(FacturasVentas facturaActualizada) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "UPDATE facturas_ventas SET fecha_factura_venta = ?, id_empleado = ?, id_cliente = ? " +
                "WHERE id_factura_venta = ?")) {
            pstmt.setDate(1, facturaActualizada.getFecha_factura_venta());
            pstmt.setInt(2, facturaActualizada.getId_empleado());
            pstmt.setInt(3, facturaActualizada.getId_cliente());
            pstmt.setInt(4, facturaActualizada.getId_factura_venta());
            pstmt.executeUpdate();

            System.out.println("Factura de venta actualizada");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarFacturaVenta(int id_factura_venta) {
        try (PreparedStatement pstmt = conexion.prepareStatement(
                "DELETE FROM facturas_ventas WHERE id_factura_venta = ?")) {
            pstmt.setInt(1, id_factura_venta);
            pstmt.executeUpdate();

            System.out.println("Factura de venta eliminada con ID: " + id_factura_venta);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
