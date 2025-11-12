package com.ejemplo.services;

import java.io.*;
import java.nio.file.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ejemplo.modelo.Semestres;
import com.google.gson.Gson;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GestionMatriculaService {

   

    /** Procesa el registro */
    public static boolean registrarMatricula(HttpServletRequest req)  {

            System.err.println("=== ENTRANDO A procesarFichero ===");

            String dni = req.getParameter("dni");
            String email = req.getParameter("email");
            String codAsig = req.getParameter("codigo");
            String semestre = req.getParameter("semestre");

            if (!MatriculaBBDD.existeEstudiante(dni)) {
                System.err.println("Usuario no autorizado.");
                return false;
            }

            if (!MatriculaBBDD.asignaturaDisponible(codAsig, semestre)){

                System.err.println("La asignatura no está disponible");
                return false;
            }

            if (!ArchivoTxtService.asignaturaDisponible(codAsig, semestre)){

                System.err.println("La asignatura no está disponible");
                return false;
            }

            boolean semestre1 = false;
            boolean semestre2 = false;

            switch (semestre) {
                case "PRIMERO":

                    semestre1 = true;
                    
                    break;

                case "SEGUNDO":

                    semestre2 = true;
                break;
            
                default:
                    break;
            }
            if (!MatriculaBBDD.insertarMatricula(dni, codAsig, semestre1, semestre2)) {

                System.err.println("Error al introducir los datos en la base de datos");
                return false;

            }

            JsonService js = new JsonService();

            String json = js.crearJson(dni, codAsig, semestre1, semestre2);

            if(json != null) return false;

            

            return true;            

    }
}
