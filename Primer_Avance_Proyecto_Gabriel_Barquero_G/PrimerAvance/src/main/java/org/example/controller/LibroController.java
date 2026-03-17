package org.example.controller;



import org.example.dao.LibroDAO;
import org.example.model.Libro;

import java.util.List;

public class LibroController {

    private LibroDAO libroDAO;

    public LibroController() {
        libroDAO = new LibroDAO();
    }

    // Crear
    public boolean agregarLibro(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria, true);
        return libroDAO.insertar(libro);
    }

    // Listar
    public List<Libro> obtenerLibros() {
        return libroDAO.listar();
    }

    // Buscar
    public Libro buscarLibro(int id) {
        return libroDAO.buscarPorId(id);
    }

    // Actualizar
    public boolean actualizarLibro(int id, String titulo, String autor, String categoria, boolean disponible) {
        Libro libro = new Libro(id, titulo, autor, categoria, disponible);
        return libroDAO.actualizar(libro);
    }

    // Eliminar
    public boolean eliminarLibro(int id) {
        return libroDAO.eliminar(id);
    }
}