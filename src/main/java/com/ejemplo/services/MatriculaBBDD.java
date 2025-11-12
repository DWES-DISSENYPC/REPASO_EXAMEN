package com.ejemplo.services;

import java.sql.*;

public class MatriculaBBDD {

    private static Connection crearConexion(String URL, String USUARIO, String PASSWORD){

      try {

        return DriverManager.getConnection(URL, USUARIO, PASSWORD);

      } catch (Exception e) {
        // TODO: handle exception
      } 

      return null;

    }



    public  static boolean existeEstudiante(String dni)  {

        String sql = "SELECT dni FROM alumnos where dni = ?";

        try (Connection con = crearConexion("ruta_base_datos_alumnos", "root", ""); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return true;

            
        } catch (SQLException e) {

            return false;
        }

        return false;
    }

    public static boolean asignaturaDisponible(String codigoAsignatura, String semestre) {

        String sql = "SELECT codigo, semestre1, semestre2  FROM asignaturas where semestre = ?";

        try (Connection con = crearConexion("ruta_base_datos_asignaturas", "root", ""); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, semestre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return true;


            
        } catch (SQLException e) {

            return false;
        }


        return false;

    }

    public static boolean insertarMatricula(String dni, String codigoAsignatura, boolean semestre1, boolean semestre2) {

        String sql = "INSERT INTO MATRICULAS (dni, codigoAsignatura, semestre1, semestre2) VALUES (?,?,?,?)";

        try (Connection con = crearConexion("ruta_base_datos_matriculas", "root", ""); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ps.setString(2, codigoAsignatura);
            ps.setBoolean(3, semestre1);
            ps.setBoolean(4, semestre2);

            int filas =ps.executeUpdate();

            if (filas > 0) return true;           

            
        } catch (SQLException e){

            return false;
        }

        return false;
    }
    
}
