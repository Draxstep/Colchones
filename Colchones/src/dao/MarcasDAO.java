package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Marcas;

public class MarcasDAO {

    private ArrayList<Marcas> lista_marcas;
    private Connection conexion;

    public MarcasDAO() throws SQLException {
        lista_marcas = new ArrayList<>();
        conexion = ConexionBD.conectarse();
    }

    public void agregarMarca(Marcas marca) {
        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO marcas (id_marca, nombre_marca) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, marca.getId_marca());
            pstmt.setString(2, marca.getNombre_marca());
            pstmt.executeUpdate();

            System.out.println("Marca agregada: " + marca.getNombre_marca());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Marcas> obtenerMarcas() throws SQLException {
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM marcas");
            while (rs.next()) {
                int id_marca = rs.getInt("id_marca");
                String nombre_marca = rs.getString("nombre_marca");
                Marcas marca = new Marcas(id_marca, nombre_marca);
                lista_marcas.add(marca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista_marcas;
    }

    public boolean actualizarMarca(Marcas marcaActualizada) {
        try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE marcas SET nombre_marca = ? WHERE id_marca = ?")) {
            pstmt.setString(1, marcaActualizada.getNombre_marca());
            pstmt.setInt(2, marcaActualizada.getId_marca());
            pstmt.executeUpdate();

            System.out.println("Marca modificada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarMarca(int id_marca) {
        try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM marcas WHERE id_marca = ?")) {
            pstmt.setInt(1, id_marca);
            pstmt.executeUpdate();

            System.out.println("Marca eliminada con ID: " + id_marca);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
