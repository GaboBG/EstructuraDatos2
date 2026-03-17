package org.example.dao;

import org.example.model.Usuario;
import org.example.misc.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends CrudFactoryDAO<Usuario> {

    @Override
    public void crear(Usuario usuario) {

        String sql = "{CALL SP_CREAR_USUARIO(?,?,?,?,?,?)}";

        try(Connection conn = Conexion.getConexion();
            CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getPrimerNombre());
            stmt.setString(4, usuario.getPrimerApellido());
            stmt.setString(5, usuario.getSegundoApellido());
            stmt.setDate(6, Date.valueOf(usuario.getFechaNacimiento()));

            stmt.execute();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Usuario usuario) {

        String sql = "{CALL SP_MODIFICAR_USUARIO(?,?,?,?,?,?,?)}";

        try(Connection conn = Conexion.getConexion();
            CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getPassword());
            stmt.setString(4, usuario.getPrimerNombre());
            stmt.setString(5, usuario.getPrimerApellido());
            stmt.setString(6, usuario.getSegundoApellido());
            stmt.setDate(7, Date.valueOf(usuario.getFechaNacimiento()));

            stmt.execute();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Usuario usuario) {

        String sql = "{CALL SP_ELIMINAR_USUARIO(?)}";

        try(Connection conn = Conexion.getConexion();
            CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, usuario.getId());
            stmt.execute();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> seleccionarTodos() {

        List<Usuario> lista = new ArrayList<>();

        String sql = "{CALL SP_LISTAR_USUARIOS()}";

        try(Connection conn = Conexion.getConexion();
            CallableStatement stmt = conn.prepareCall(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){

                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setPrimerNombre(rs.getString("primerNombre"));
                u.setPrimerApellido(rs.getString("primerApellido"));

                lista.add(u);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Usuario seleccionarPorId(int id) {

        Usuario u = null;

        String sql = "{CALL SP_BUSCAR_USUARIO(?)}";

        try(Connection conn = Conexion.getConexion();
            CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){

                u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setPrimerNombre(rs.getString("primerNombre"));
                u.setPrimerApellido(rs.getString("primerApellido"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return u;
    }
}