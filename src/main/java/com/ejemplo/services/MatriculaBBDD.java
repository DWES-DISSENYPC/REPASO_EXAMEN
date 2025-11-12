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



    public  static boolean existeEstudiante(String dni) throws SQLException {

        try (Connection con = crearConexion("ruta_base_datos_alumnos", "root", "")) {

            String sql = "SELECT dni FROM alumnos where dni = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return true;

            
        }

        return false;
    }

    public static boolean asignaturaDisponible(String codigoAsignatura, String semestre) throws SQLException{

        try (Connection con = crearConexion("ruta_base_datos_asignaturas", "root", "")) {

            String sql = "SELECT codigo, semestre1, semestre2  FROM asignaturas where semestre = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, semestre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return true;


            
        }


        return false;

    }

    public static boolean insertarMatricula(String dni, String codigoAsignatura, String semestre) throws SQLException{

        try (Connection con = crearConexion("ruta_base_datos_matriculas", "root", "")) {

            String sql = "INSERT INTO MATRICULAS (dni, codigoAsignatura, semestre) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dni);
            ps.setString(2, codigoAsignatura);
            ps.setString(3, semestre);

            int filas =ps.executeUpdate();

            if (filas > 0) return true;           

            
        }

        return false;
    }
    
}
