package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Direcciones;

public class DireccionesDAO {

    private ArrayList<Direcciones> lista_direcciones;
    private Connection conexion;

    public DireccionesDAO() throws SQLException {
        lista_direcciones = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarDireccion(Direcciones direccion) {
        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO direcciones (id_direccion, tipo_calle, numero_edificio, descripcion_direccion, id_lugar) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, direccion.getId_direccion());
            pstmt.setString(2, String.valueOf(direccion.getTipo_calle()));
            pstmt.setInt(3, direccion.getNumero_edificio());
            pstmt.setString(4, direccion.getDescripcion_direccion());
            pstmt.setInt(5, direccion.getId_lugar());
            pstmt.executeUpdate();

            System.out.println("Dirección agregada: " + direccion.getDescripcion_direccion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Direcciones> obtenerDirecciones() throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM direcciones");
            while (rs.next()) {
                int id_direccion = rs.getInt("id_direccion");
                char tipo_calle = rs.getString("tipo_calle").charAt(0);
                int numero_edificio = rs.getInt("numero_edificio");
                String descripcion_direccion = rs.getString("descripcion_direccion");
                int id_lugar = rs.getInt("id_lugar");
                Direcciones direccion = new Direcciones(id_direccion, tipo_calle, numero_edificio, descripcion_direccion, id_lugar);
                lista_direcciones.add(direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_direcciones;
    }

    public boolean actualizarDireccion(Direcciones direccionActualizada) {
        try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE direcciones SET tipo_calle = ?, numero_edificio = ?, descripcion_direccion = ?, id_lugar = ? WHERE id_direccion = ?")) {
            pstmt.setString(1, String.valueOf(direccionActualizada.getTipo_calle()));
            pstmt.setInt(2, direccionActualizada.getNumero_edificio());
            pstmt.setString(3, direccionActualizada.getDescripcion_direccion());
            pstmt.setInt(4, direccionActualizada.getId_lugar());
            pstmt.setInt(5, direccionActualizada.getId_direccion());
            pstmt.executeUpdate();

            System.out.println("Dirección modificada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarDireccion(int id_direccion) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM direcciones WHERE id_direccion = ?")) {
            pstmt.setInt(1, id_direccion);
            pstmt.executeUpdate();

            System.out.println("Dirección eliminada con ID: " + id_direccion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
