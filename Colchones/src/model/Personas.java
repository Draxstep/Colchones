package model;

import java.sql.Date;

public class Personas {

    private int id_persona;
    private Date fecha_nacimiento;
    private String nombres;
    private int tipo_persona;
    private int id_cargo;

    public Personas(int id_persona, Date fecha_nacimiento, String nombres, int tipo_persona, int id_cargo) {
        this.id_persona = id_persona;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombres = nombres;
        this.tipo_persona = tipo_persona;
        this.id_cargo = id_cargo;
    }
    public int getId_persona() {
        return id_persona;
    }
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public int getTipo_persona() {
        return tipo_persona;
    }
    public void setTipo_persona(int tipo_persona) {
        this.tipo_persona = tipo_persona;
    }
    public int getId_cargo() {
        return id_cargo;
    }
    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    
    
}
