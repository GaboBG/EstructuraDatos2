package org.example.dao;

import org.example.misc.Conexion;
import org.example.model.Prestamo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    // ✅ CREATE
    public boolean insertar(Prestamo prestamo) {
        String sql = "INSERT INTO Gabriel_Proyecto_prestamos (idLibro, idUsuario, fechaPrestamo, fechaDevolucion) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getIdLibro());
            ps.setInt(2, prestamo.getIdUsuario());
            ps.setDate(3, Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setDate(4, Date.valueOf(prestamo.getFechaDevolucion()));

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar préstamo: " + e.getMessage());
            return false;
        }
    }

    // ✅ READ (listar todos)
    public List<Prestamo> listar() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Gabriel_Proyecto_prestamos";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Prestamo p = new Prestamo(
                        rs.getInt("id"),
                        rs.getInt("idLibro"),
                        rs.getInt("idUsuario"),
                        rs.getDate("fechaPrestamo").toLocalDate(),
                        rs.getDate("fechaDevolucion").toLocalDate()
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar préstamos: " + e.getMessage());
        }

        return lista;
    }

    // ✅ READ por ID
    public Prestamo buscarPorId(int id) {
        String sql = "SELECT * FROM Gabriel_Proyecto_prestamos WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Prestamo(
                        rs.getInt("id"),
                        rs.getInt("idLibro"),
                        rs.getInt("idUsuario"),
                        rs.getDate("fechaPrestamo").toLocalDate(),
                        rs.getDate("fechaDevolucion").toLocalDate()
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar préstamo: " + e.getMessage());
        }

        return null;
    }

    // ✅ UPDATE
    public boolean actualizar(Prestamo prestamo) {
        String sql = "UPDATE Gabriel_Proyecto_prestamos SET idLibro=?, idUsuario=?, fechaPrestamo=?, fechaDevolucion=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getIdLibro());
            ps.setInt(2, prestamo.getIdUsuario());
            ps.setDate(3, Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setDate(4, Date.valueOf(prestamo.getFechaDevolucion()));
            ps.setInt(5, prestamo.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar préstamo: " + e.getMessage());
            return false;
        }
    }

    // ✅ DELETE
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Gabriel_Proyecto_prestamos WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar préstamo: " + e.getMessage());
            return false;
        }
    }
}