package org.example.controller;

import org.example.dao.PrestamoDAO;
import org.example.model.Prestamo;

import java.util.List;

public class PrestamoController {

    private PrestamoDAO prestamoDAO;

    public PrestamoController() {
        prestamoDAO = new PrestamoDAO();
    }

    public boolean agregarPrestamo(int idLibro, int idUsuario, java.time.LocalDate fechaPrestamo, java.time.LocalDate fechaDevolucion) {
        Prestamo p = new Prestamo(idLibro, idUsuario, fechaPrestamo, fechaDevolucion);
        return prestamoDAO.insertar(p);
    }

    public List<Prestamo> obtenerPrestamos() {
        return prestamoDAO.listar();
    }

    public Prestamo buscarPrestamo(int id) {
        return prestamoDAO.buscarPorId(id);
    }

    public boolean actualizarPrestamo(int id, int idLibro, int idUsuario, java.time.LocalDate fechaPrestamo, java.time.LocalDate fechaDevolucion) {
        Prestamo p = new Prestamo(id, idLibro, idUsuario, fechaPrestamo, fechaDevolucion);
        return prestamoDAO.actualizar(p);
    }

    public boolean eliminarPrestamo(int id) {
        return prestamoDAO.eliminar(id);
    }
}