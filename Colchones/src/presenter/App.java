package presenter;

import dao.ConexionBD;
import dao.Marcas;

public class App {
    public static void main(String[] args) throws Exception {
        ConexionBD conn = new ConexionBD();
        Marcas marcas = new Marcas();
        marcas.insertarDato(1, "Comodisimos");
    }
}
