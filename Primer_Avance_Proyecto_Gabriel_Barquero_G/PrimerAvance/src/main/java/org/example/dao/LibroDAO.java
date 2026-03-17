package org.example.dao;



import org.example.model.Libro;
import org.example.misc.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {


    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO Gabriel_Proyecto_libros (titulo, autor, categoria, disponible) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getCategoria());
            ps.setBoolean(4, libro.isDisponible());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar libro");
            return false;
        }
    }


    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Gabriel_Proyecto_libros";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("categoria"),
                        rs.getBoolean("disponible")
                );
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar libros");
        }

        return lista;
    }


    public Libro buscarPorId(int id) {
        String sql = "SELECT * FROM Gabriel_Proyecto_libros WHERE id = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("categoria"),
                        rs.getBoolean("disponible")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar libro");
        }

        return null;
    }


    public boolean actualizar(Libro libro) {
        String sql = "UPDATE Gabriel_Proyecto_libros SET titulo=?, autor=?, categoria=?, disponible=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getCategoria());
            ps.setBoolean(4, libro.isDisponible());
            ps.setInt(5, libro.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar libro");
            return false;
        }
    }


    public boolean eliminar(int id) {
        String sql = "DELETE FROM Gabriel_Proyecto_libros WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar libro");
            return false;
        }
    }
}