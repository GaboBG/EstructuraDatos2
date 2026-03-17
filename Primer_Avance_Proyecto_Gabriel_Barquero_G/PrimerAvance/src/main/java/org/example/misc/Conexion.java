package org.example.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://195.35.59.3:3306/u484426513_anac126?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "u484426513_anac126";
    private static final String PASSWORD = "5E~g$ql?Jk";

    //Meotodo para obtener la conexion
    public static Connection getConexion() {
        try{
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexion establecida!");
            return conexion;
        }catch(SQLException e){
            System.out.println("Error al conectar con la base de datos");
            return null;
        }
    }

}
