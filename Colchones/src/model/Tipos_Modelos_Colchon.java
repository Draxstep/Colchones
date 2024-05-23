package model;

public class Tipos_Modelos_Colchon {

    private int id_tipo_modelo_colchon;
    private String nombre_tipo_colchon;
    private String descripcion_tipo_modelo;
    
    public Tipos_Modelos_Colchon(int id_tipo_modelo_colchon, String nombre_tipo_colchon,
            String descripcion_tipo_modelo) {
        this.id_tipo_modelo_colchon = id_tipo_modelo_colchon;
        this.nombre_tipo_colchon = nombre_tipo_colchon;
        this.descripcion_tipo_modelo = descripcion_tipo_modelo;
    }

    public int getId_tipo_modelo_colchon() {
        return id_tipo_modelo_colchon;
    }

    public void setId_tipo_modelo_colchon(int id_tipo_modelo_colchon) {
        this.id_tipo_modelo_colchon = id_tipo_modelo_colchon;
    }

    public String getNombre_tipo_colchon() {
        return nombre_tipo_colchon;
    }

    public void setNombre_tipo_colchon(String nombre_tipo_colchon) {
        this.nombre_tipo_colchon = nombre_tipo_colchon;
    }

    public String getDescripcion_tipo_modelo() {
        return descripcion_tipo_modelo;
    }

    public void setDescripcion_tipo_modelo(String descripcion_tipo_modelo) {
        this.descripcion_tipo_modelo = descripcion_tipo_modelo;
    }

    
    
}
