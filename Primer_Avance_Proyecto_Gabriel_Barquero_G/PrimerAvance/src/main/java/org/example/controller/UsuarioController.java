package org.example.controller;


import org.example.dao.UsuarioDAO;
import org.example.model.Usuario;

import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    // Crear
    public boolean agregarUsuario(String nombre, String cedula, String tipo) {
        Usuario usuario = new Usuario(nombre, cedula, tipo);
        return usuarioDAO.insertar(usuario);
    }

    // Listar
    public List<Usuario> obtenerUsuarios() {
        return usuarioDAO.listar();
    }

    // Buscar
    public Usuario buscarUsuario(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    // Actualizar
    public boolean actualizarUsuario(int id, String nombre, String cedula, String tipo) {
        Usuario usuario = new Usuario(id, nombre, cedula, tipo);
        return usuarioDAO.actualizar(usuario);
    }

    // Eliminar
    public boolean eliminarUsuario(int id) {
        return usuarioDAO.eliminar(id);
    }
}