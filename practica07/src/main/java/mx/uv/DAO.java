package mx.uv;

import java.sql.*;
import java.util.*;

// Objetivo independizar la logica de negocio
// De la comunicacion con la BD
public class DAO {
    public static conexion c = new conexion();

    public static List<usuario> listaUsuario(){
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<usuario> resultado = new ArrayList<>();

        con = conexion.getConnection();

        try {
            String query = "SELECT * FROM usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                usuario u = new usuario(
                    rs.getString("id"), 
                    rs.getString("nombre"), 
                    rs.getString("password"));
                resultado.add(u);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        } finally {
            // vamos a liberar en este bloque todos los recursos empleando
            // se hace en orden inverso a su creación
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                rs = null;
            }

            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                con.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    
        return resultado;
    }

    public static String crearUsuario(usuario u){
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = c.getConnection();
        try {
            String query = "insert into usuarios (id, nombre, password) values (null,?,?)";
            stm = (PreparedStatement) con.prepareStatement(query);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "El usuario se agrego";
            else 
                msj = "El usuario no se agrego";
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            // vamos a liberar en este bloque todos los recursos empleando
            // se hace en orden inverso a su creación

            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                con.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return msj;
    }
}
