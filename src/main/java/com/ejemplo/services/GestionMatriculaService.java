package com.ejemplo.services;

import com.ejemplo.modelo.*;
import jakarta.servlet.http.*;

public class GestionMatriculaService {

    /** Procesa el registro */
    public static Respuestas registrarMatricula(HttpServletRequest req)  {

            System.err.println("=== ENTRANDO A procesarFichero ===");

            Respuestas ok = new Respuestas(true);

            String dni = req.getParameter("dni");
            String email = req.getParameter("email");
            String codAsig = req.getParameter("codigo");
            String semestre = req.getParameter("semestre");

            if (!MatriculaBBDD.existeEstudiante(dni)) {
                System.err.println("Usuario no autorizado.");
                ok.setOk( false );
                return ok;
            }

            if (!MatriculaBBDD.asignaturaDisponible(codAsig, semestre)){

                System.err.println("La asignatura no está disponible");
                ok.setOk( false );
                return ok;
            }

            if (!ArchivoTxtService.asignaturaDisponible(codAsig, semestre)){

                System.err.println("La asignatura no está disponible");
                ok.setOk( false );
                return ok;
            }

            Semestres s = Semestres.PRIMERO;

            switch (semestre) {
                case "PRIMERO":

                   s = Semestres.PRIMERO; 
                    break;

                case "SEGUNDO":

                   s = Semestres.SEGUNDO; 
                    break;
            
                default:
                    break;
            }
            

            if (!MatriculaBBDD.insertarMatricula(dni, codAsig, s)) {

                System.err.println("Error al introducir los datos en la base de datos");
                ok.setOk( false );
                return ok;

            }

            JsonService js = new JsonService();

            String json = js.crearJson(dni, codAsig, semestre);

            if(json != null) {
                
                ok.setOk( false );
                return ok;


            }

            ok.setMatricula(json);
            ok.setOk(true);

            return ok;            

    }
}
