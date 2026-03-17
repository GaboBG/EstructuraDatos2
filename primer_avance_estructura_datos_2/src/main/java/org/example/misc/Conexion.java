package org.example.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=Proyecto_2;encrypt=false";

    private static final String USUARIO = "Mi_nombre_DeUsuario";
    private static final String PASSWORD = "Mi_Contrasena";

    //Metodo para obtener la conexion
    public static Connection getConexion() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexion establecida!");

        } catch (SQLException e) {

            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();

        }

        return conexion;
    }
}