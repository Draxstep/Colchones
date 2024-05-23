package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Personas {

    private ArrayList<model.Personas> lista_personas;
    private Connection conexion;
    
    public Personas() throws SQLException {
        lista_personas = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarPersona(model.Personas persona) {

        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO personas (fecha_nacimiento_persona, nombres_persona, tipo_persona, id_cargo) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, persona.getFecha_nacimiento());
            pstmt.setString(2, persona.getNombres());
            pstmt.setInt(3, persona.getTipo_persona());
            pstmt.setInt(4, persona.getId_cargo());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    persona.setId_persona(generatedKeys.getInt(1));
                }
            }

            System.out.println("Persona agregada: " + persona.getNombres());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<model.Personas> obtenerPersonas() throws SQLException {
        
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM personas");
            while (rs.next()) {
                int id_persona = rs.getInt("id_persona");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento_persona");
                String nombres_persona = rs.getString("nombres_persona");
                int tipo_persona = rs.getInt("tipo_persona");
                int id_cargo = rs.getInt("id_cargo");
                model.Personas persona = new model.Personas(id_persona, fecha_nacimiento, nombres_persona, tipo_persona, id_cargo);
                lista_personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_personas;
    }

    public boolean actualizarPersona(model.Personas personaActualizado) {
        try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE personas SET fecha_nacimiento_persona = ?, nombres_persona = ?, tipo_persona = ?, id_cargo = ? WHERE id_persona = ?")) {
            pstmt.setDate(1, personaActualizado.getFecha_nacimiento());
            pstmt.setString(2, personaActualizado.getNombres());
            pstmt.setInt(3, personaActualizado.getTipo_persona());
            pstmt.setInt(4, personaActualizado.getId_cargo());
            pstmt.setInt(5, personaActualizado.getId_persona());
            pstmt.executeUpdate();

            System.out.println("Modificado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarPersona(int id_persona) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM personas WHERE id_persona = ?")) {
            pstmt.setInt(1, id_persona);
            pstmt.executeUpdate(); 

            System.out.println("Persona eliminada con ID: " + id_persona);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
