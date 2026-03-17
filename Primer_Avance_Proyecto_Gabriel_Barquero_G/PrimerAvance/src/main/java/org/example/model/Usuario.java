package org.example.model;

public class Usuario {

    private int id;
    private String nombre;
    private String cedula;
    private String tipo; // estudiante / profesor

    public Usuario() {}

    public Usuario(String nombre, String cedula, String tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipo = tipo;
    }

    public Usuario(int id, String nombre, String cedula, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}