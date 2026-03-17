package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Grupo extends BaseModel{

    private String nombre;
    private String Color;
    private ArrayList<Usuario> usuarios;


    public Grupo(int id, LocalDate fechaCreacion, LocalDate fechaModificacion) {
        super(id, fechaCreacion, fechaModificacion);
    }

    public Grupo(int id, LocalDate fechaCreacion, LocalDate fechaModificacion, String nombre, String color, ArrayList<Usuario> usuarios) {
        super(id, fechaCreacion, fechaModificacion);
        this.nombre = nombre;
        Color = color;
        this.usuarios = usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
