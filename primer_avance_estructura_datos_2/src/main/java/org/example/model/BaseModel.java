package org.example.model;

import java.time.LocalDate;

public class BaseModel {

    private int id;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;

    public BaseModel() {
    }

    public BaseModel(int id, LocalDate fechaCreacion, LocalDate fechaModificacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
