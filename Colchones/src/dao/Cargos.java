package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cargos {

    private ArrayList<model.Cargos> lista_cargos;
    private Connection conexion;

    public Cargos() throws SQLException {
        lista_cargos = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarCargo(model.Cargos cargo) {

        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO cargos (nombre_cargo, descripcion_cargo, salario_cargo) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, cargo.getNombre_cargo());
            pstmt.setString(2, cargo.getDescripcion_cargo());
            pstmt.setInt(3, cargo.getSalario_cargo());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cargo.setId_cargo(generatedKeys.getInt(1));
                }
            }

            System.out.println("Cargo agregado: " + cargo.getNombre_cargo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<model.Cargos> obtenerCargos() throws SQLException {
        
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM cargos");
            while (rs.next()) {
                int id_cargo = rs.getInt("id_cargo");
                String nombre_cargo = rs.getString("nombre_cargo");
                String descripcion_cargo = rs.getString("descripcion_cargo");
                int salario_cargo = rs.getInt("salario_cargo");
                model.Cargos cargo = new model.Cargos(id_cargo, nombre_cargo, descripcion_cargo, salario_cargo);
                lista_cargos.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_cargos;
    }

    public boolean actualizarCargo(model.Cargos cargoActualizado) {
        try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE cargos SET nombre_cargo = ?, descripcion_cargo = ?, salario_cargo = ? WHERE id_cargo = ?")) {
            pstmt.setString(1, cargoActualizado.getNombre_cargo());
            pstmt.setString(2, cargoActualizado.getDescripcion_cargo());
            pstmt.setInt(3, cargoActualizado.getSalario_cargo());
            pstmt.setInt(4, cargoActualizado.getId_cargo());
            pstmt.executeUpdate();

            System.out.println("Modificado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCargo(int id_cargo) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM cargos WHERE id_cargo = ?")) {
            pstmt.setInt(1, id_cargo);
            pstmt.executeUpdate();

            System.out.println("Cargo eliminado con ID: " + id_cargo);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
