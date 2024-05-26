package dao;

import java.sql.*;
import java.util.ArrayList;
import model.DireccionesPersona;

public class DireccionesPersonaDAO {

    private ArrayList<DireccionesPersona> lista_direcciones_persona;
    private Connection conexion;

    public DireccionesPersonaDAO() throws SQLException {
        lista_direcciones_persona = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarDireccionPersona(DireccionesPersona direccionPersona) {
        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO direcciones_persona (id_direccion, id_persona) VALUES (?, ?)")) {
            pstmt.setInt(1, direccionPersona.getId_direccion());
            pstmt.setInt(2, direccionPersona.getId_persona());
            pstmt.executeUpdate();

            System.out.println("Dirección-Persona agregada: " + direccionPersona.getId_direccion() + " - " + direccionPersona.getId_persona());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DireccionesPersona> obtenerDireccionesPersona() throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM direcciones_persona");
            while (rs.next()) {
                int id_direccion = rs.getInt("id_direccion");
                int id_persona = rs.getInt("id_persona");
                DireccionesPersona direccionPersona = new DireccionesPersona(id_direccion, id_persona);
                lista_direcciones_persona.add(direccionPersona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_direcciones_persona;
    }

    public boolean eliminarDireccionPersona(int id_direccion, int id_persona) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM direcciones_persona WHERE id_direccion = ? AND id_persona = ?")) {
            pstmt.setInt(1, id_direccion);
            pstmt.setInt(2, id_persona);
            pstmt.executeUpdate();

            System.out.println("Dirección-Persona eliminada: " + id_direccion + " - " + id_persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
