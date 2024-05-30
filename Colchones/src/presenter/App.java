package presenter;

import dao.*;
import model.*;

public class App {
    public static void main(String[] args) throws Exception {
        ConexionBD.conectarse();

        // CRUD MARCAS
        // MarcasDAO marcas = new MarcasDAO();
        // Marcas m = new Marcas(1, "Marca 1");
        // marcas.agregarMarca(m);
        // marcas.obtenerMarcas().forEach(marca -> System.out.println(marca.getNombre_marca()));
        // m.setNombre_marca("Marca 1 Modificada");
        // marcas.actualizarMarca(m);
        // marcas.eliminarMarca(1);

        // CRUD LUGARES
        // Lugares l = new Lugares(1, "Lugar 1", 'A', 1);
        // LugaresDAO lugares = new LugaresDAO();
        // // lugares.agregarLugar(l); 
        // lugares.obtenerLugares().forEach(lugar -> System.out.println(lugar.getNombre_lugar()));
        // l.setNombre_lugar("Lugar 1 Modificado");
        // lugares.actualizarLugar(l);
        // lugares.eliminarLugar(1); 

        // CRUD DIRECCIONES
        // DireccionesDAO direcciones = new DireccionesDAO();
        // Direcciones d = new Direcciones(1, 'C', 50, "Apartamento 24", 3);
        // direcciones.agregarDireccion(d);
        // direcciones.obtenerDirecciones().forEach(direccion -> System.out.println(direccion.getDescripcion_direccion()));
        // d.setDescripcion_direccion("Apartamento 24 Modificado");
        // direcciones.actualizarDireccion(d);
        // direcciones.eliminarDireccion(1);

        // CRUD DIRECCIONESPERSONA
        // DireccionesPersonaDAO direccionesPersona = new DireccionesPersonaDAO();
        // DireccionesPersona dp = new DireccionesPersona(1, 1);
        // direccionesPersona.agregarDireccionPersona(dp);
        // direccionesPersona.obtenerDireccionesPersona().forEach(direccionPersona -> System.out.println(direccionPersona.getId_direccion() + " - " + direccionPersona.getId_persona()));
        // dp.setId_persona(2);
        // direccionesPersona.actualizarDireccionPersona(dp);
        // direccionesPersona.eliminarDireccionPersona(1, 2);

    }
}
