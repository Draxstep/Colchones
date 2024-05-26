package model;

public class Lugares {
    private int id_lugar;
    private String nombre_lugar;
    private char tipo_lugar;
    private Integer id_lugar_ubicacion; // Puede ser nulo

    public Lugares(int id_lugar, String nombre_lugar, char tipo_lugar, Integer id_lugar_ubicacion) {
        this.id_lugar = id_lugar;
        this.nombre_lugar = nombre_lugar;
        this.tipo_lugar = tipo_lugar;
        this.id_lugar_ubicacion = id_lugar_ubicacion;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }

    public char getTipo_lugar() {
        return tipo_lugar;
    }

    public void setTipo_lugar(char tipo_lugar) {
        this.tipo_lugar = tipo_lugar;
    }

    public Integer getId_lugar_ubicacion() {
        return id_lugar_ubicacion;
    }

    public void setId_lugar_ubicacion(Integer id_lugar_ubicacion) {
        this.id_lugar_ubicacion = id_lugar_ubicacion;
    }
}
