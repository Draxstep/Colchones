package model;

public class Cargos {

    private int id_cargo;
    private String nombre_cargo;
    private String descripcion_cargo;
    private int salario_cargo;
    
    public Cargos(int id_cargo, String nombre_cargo, String descripcion_cargo, int salario_cargo) {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
        this.descripcion_cargo = descripcion_cargo;
        this.salario_cargo = salario_cargo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

    public int getSalario_cargo() {
        return salario_cargo;
    }

    public void setSalario_cargo(int salario_cargo) {
        this.salario_cargo = salario_cargo;
    }

    
    
}
