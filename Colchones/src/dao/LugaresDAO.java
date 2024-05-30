package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Lugares;

public class LugaresDAO {

    private ArrayList<Lugares> lista_lugares;
    private Connection conexion;

    public LugaresDAO() throws SQLException {
        lista_lugares = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarLugar(Lugares lugar) {
        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO lugares (id_lugar, nombre_lugar, tipo_lugar, id_lugar_ubicacion) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, lugar.getId_lugar());
            pstmt.setString(2, lugar.getNombre_lugar());
            pstmt.setString(3, String.valueOf(lugar.getTipo_lugar()));
            if (lugar.getId_lugar_ubicacion() != null) {
                pstmt.setInt(4, lugar.getId_lugar_ubicacion());
            } else {
                pstmt.setNull(4, java.sql.Types.INTEGER);
            }
            pstmt.executeUpdate();

            System.out.println("Lugar agregado: " + lugar.getNombre_lugar());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Lugares> obtenerLugares() throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM lugares");
            while (rs.next()) {
                int id_lugar = rs.getInt("id_lugar");
                String nombre_lugar = rs.getString("nombre_lugar");
                char tipo_lugar = rs.getString("tipo_lugar").charAt(0);
                Integer id_lugar_ubicacion = rs.getObject("id_lugar_ubicacion") != null ? rs.getInt("id_lugar_ubicacion") : null;
                Lugares lugar = new Lugares(id_lugar, nombre_lugar, tipo_lugar, id_lugar_ubicacion);
                lista_lugares.add(lugar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_lugares;
    }

    public boolean actualizarLugar(Lugares lugarActualizado) {
        try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE lugares SET nombre_lugar = ?, tipo_lugar = ?, id_lugar_ubicacion = ? WHERE id_lugar = ?")) {
            pstmt.setString(1, lugarActualizado.getNombre_lugar());
            pstmt.setString(2, String.valueOf(lugarActualizado.getTipo_lugar()));
            if (lugarActualizado.getId_lugar_ubicacion() != null) {
                pstmt.setInt(3, lugarActualizado.getId_lugar_ubicacion());
            } else {
                pstmt.setNull(3, java.sql.Types.INTEGER);
            }
            pstmt.setInt(4, lugarActualizado.getId_lugar());
            pstmt.executeUpdate();

            System.out.println("Lugar modificado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarLugar(int id_lugar) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM lugares WHERE id_lugar = ?")) {
            pstmt.setInt(1, id_lugar);
            pstmt.executeUpdate();

            System.out.println("Lugar eliminado con ID: " + id_lugar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
