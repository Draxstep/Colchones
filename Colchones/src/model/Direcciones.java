package model;

public class Direcciones {
    private int id_direccion;
    private char tipo_calle;
    private int numero_edificio;
    private String descripcion_direccion;
    private int id_lugar;

    public Direcciones(int id_direccion, char tipo_calle, int numero_edificio, String descripcion_direccion, int id_lugar) {
        this.id_direccion = id_direccion;
        this.tipo_calle = tipo_calle;
        this.numero_edificio = numero_edificio;
        this.descripcion_direccion = descripcion_direccion;
        this.id_lugar = id_lugar;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public char getTipo_calle() {
        return tipo_calle;
    }

    public void setTipo_calle(char tipo_calle) {
        this.tipo_calle = tipo_calle;
    }

    public int getNumero_edificio() {
        return numero_edificio;
    }

    public void setNumero_edificio(int numero_edificio) {
        this.numero_edificio = numero_edificio;
    }

    public String getDescripcion_direccion() {
        return descripcion_direccion;
    }

    public void setDescripcion_direccion(String descripcion_direccion) {
        this.descripcion_direccion = descripcion_direccion;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }
}
