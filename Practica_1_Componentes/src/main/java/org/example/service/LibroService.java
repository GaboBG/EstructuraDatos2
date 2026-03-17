package org.example.service;


import java.util.List;
import org.example.model.Libro;

public interface LibroService {
    Libro guardar(Libro libro);
    List<Libro> listar();
}